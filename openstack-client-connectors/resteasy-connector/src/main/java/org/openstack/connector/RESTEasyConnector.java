package org.openstack.connector;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.ext.ContextResolver;

import org.apache.commons.httpclient.HttpStatus;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientRequestFactory;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.base.client.OpenStackResponseException;

public class RESTEasyConnector implements OpenStackClientConnector {

	public static ObjectMapper DEFAULT_MAPPER;

	public static ObjectMapper WRAPPED_MAPPER;

	public static ClientRequestFactory CLIENT_FACTORY;

	static {
		DEFAULT_MAPPER = new ObjectMapper();

		DEFAULT_MAPPER.setSerializationInclusion(Inclusion.NON_NULL);
		DEFAULT_MAPPER.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		DEFAULT_MAPPER.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		WRAPPED_MAPPER = new ObjectMapper();

		WRAPPED_MAPPER.setSerializationInclusion(Inclusion.NON_NULL);
		WRAPPED_MAPPER.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		WRAPPED_MAPPER.enable(SerializationConfig.Feature.WRAP_ROOT_VALUE);
		WRAPPED_MAPPER.enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);
		WRAPPED_MAPPER.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		ResteasyProviderFactory providerFactory = new ResteasyProviderFactory();
		providerFactory.addContextResolver(new ContextResolver<ObjectMapper>() {
			public ObjectMapper getContext(Class<?> type) {
				return type.getAnnotation(JsonRootName.class) == null ? DEFAULT_MAPPER : WRAPPED_MAPPER;
			}
		});

		JacksonJsonProvider jsonProvider = new JacksonJsonProvider();
		providerFactory.addMessageBodyReader(jsonProvider);
		providerFactory.addMessageBodyWriter(jsonProvider);

		CLIENT_FACTORY = new ClientRequestFactory(ClientRequest.getDefaultExecutor(), providerFactory);
	}

	@Override
	public <T> T execute(OpenStackRequest<T> request) {
		ClientRequest client = CLIENT_FACTORY.createRequest(request.endpoint() + "/" + request.path());
		for(Map.Entry<String, Object> entry : request.queryParams().entrySet()) {
			client = client.queryParameter(entry.getKey(), String.valueOf(entry.getValue()));
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
		                || response.getStatus() == HttpStatus.SC_NO_CONTENT) {
		        return response.getEntity(request.returnType());
		}

		response.releaseConnection();

		throw new OpenStackResponseException(response.getResponseStatus()
				.getReasonPhrase(), response.getStatus());
	}

}
