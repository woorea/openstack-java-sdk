package com.woorea.openstack.connector;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.http.HttpStatus;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.plugins.providers.InputStreamProvider;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.base.client.OpenStackResponseException;

public class RESTEasyConnector implements OpenStackClientConnector {

	public static ObjectMapper DEFAULT_MAPPER;

	public static ObjectMapper WRAPPED_MAPPER;

	@Provider
	@Produces(MediaType.APPLICATION_JSON)
	static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
		public ObjectMapper getContext(Class<?> type) {
			return type.getAnnotation(JsonRootName.class) == null ? DEFAULT_MAPPER : WRAPPED_MAPPER;
		}
	}

	private static ResteasyProviderFactory providerFactory;

	static {
		DEFAULT_MAPPER = new ObjectMapper();

		DEFAULT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		DEFAULT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
		DEFAULT_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		DEFAULT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		DEFAULT_MAPPER.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

		WRAPPED_MAPPER = new ObjectMapper();

		WRAPPED_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		WRAPPED_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
		WRAPPED_MAPPER.enable(SerializationFeature.WRAP_ROOT_VALUE);
		WRAPPED_MAPPER.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		WRAPPED_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		WRAPPED_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		WRAPPED_MAPPER.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

		providerFactory = new ResteasyProviderFactory();
		providerFactory.registerProviderInstance(new JacksonJsonProvider());
		providerFactory.registerProviderInstance(new ObjectMapperContextResolver());
		providerFactory.registerProviderInstance(new InputStreamProvider());
	}

	protected ClientExecutor createClientExecutor() {
		return ClientRequest.getDefaultExecutor();
	}

	public <T> OpenStackResponse request(OpenStackRequest<T> request) {
		String requestPath = request.path();
		if (requestPath != null && requestPath.isEmpty()) {
			requestPath = "/";
		}
		ClientRequest client = new ClientRequest(UriBuilder.fromUri(request.endpoint() + requestPath),
				createClientExecutor(), providerFactory);

		for(Map.Entry<String, List<Object> > entry : request.queryParams().entrySet()) {
			for (Object o : entry.getValue()) {
				client = client.queryParameter(entry.getKey(), String.valueOf(o));
			}
		}

		for (Entry<String, List<Object>> h : request.headers().entrySet()) {
			StringBuilder sb = new StringBuilder();
			for (Object v : h.getValue()) {
				sb.append(String.valueOf(v));
			}
			client.header(h.getKey(), sb);
		}

		if (request.entity() != null) {
			client.body(request.entity().getContentType(), request.entity().getEntity());
		}

		ClientResponse<T> response;

		try {
			response = client.httpMethod(request.method().name(), request.returnType());
		} catch (Exception e) {
			throw new RuntimeException("Unexpected client exception", e);
		}

		if (response.getStatus() == HttpStatus.SC_OK
				|| response.getStatus() == HttpStatus.SC_CREATED
				|| response.getStatus() == HttpStatus.SC_NO_CONTENT
				|| response.getStatus() == HttpStatus.SC_ACCEPTED) {
			return new RESTEasyResponse(client, response);
		}

		response.releaseConnection();

		throw new OpenStackResponseException(response.getResponseStatus()
				.getReasonPhrase(), response.getStatus());
	}

}
