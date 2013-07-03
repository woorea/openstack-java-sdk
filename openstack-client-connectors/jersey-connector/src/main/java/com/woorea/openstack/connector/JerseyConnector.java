package com.woorea.openstack.connector;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.client.impl.ClientRequestImpl;
import com.sun.jersey.core.header.OutBoundHeaders;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.base.client.OpenStackResponse;
import com.woorea.openstack.base.client.OpenStackResponseException;

public class JerseyConnector implements OpenStackClientConnector {
	
	protected Client client = null;

	public JerseyConnector() {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getClasses().add(JacksonJaxbJsonProvider.class);
		clientConfig.getClasses().add(OpenStackObjectMapper.class);
		client = Client.create(clientConfig);
	}

	@Override
	public <T> OpenStackResponse request(OpenStackRequest<T> request) {
		WebResource target = client.resource(request.endpoint()).path(request.path());
		for(Map.Entry<String, List<Object> > entry : request.queryParams().entrySet()) {
			for (Object o : entry.getValue()) {
				target = target.queryParam(entry.getKey(), String.valueOf(o));
			}
		}
		target.addFilter(new LoggingFilter());
		MultivaluedMap<String, Object> headers = new OutBoundHeaders();
		for(Map.Entry<String, List<Object>> h : request.headers().entrySet()) {
			for(Object v : h.getValue()) {
				headers.add(h.getKey(), v);
			}
		}
		if(request.entity() != null && request.entity().getContentType() != null) {
			headers.add("Content-Type", request.entity().getContentType());
		} else {
			headers.add("Content-Type", "application/json");
		}
		try {
			ClientResponse response = null;
			if (request.entity() != null && request.entity().getEntity() != null) {
				response = target.getHeadHandler().handle(new ClientRequestImpl(target.getURI(), request.method().name(), request.entity().getEntity(), headers));
			} else {
				response = target.getHeadHandler().handle(new ClientRequestImpl(target.getURI(), request.method().name(), null, headers));
			}
			return new JerseyResponse(response);
		} catch (UniformInterfaceException e) {
			throw new OpenStackResponseException(e.getResponse().getClientResponseStatus().getReasonPhrase(), e.getResponse().getStatus());
		}
	}

	@Provider
	public static class OpenStackObjectMapper implements ContextResolver<ObjectMapper> {
		static ObjectMapper DEFAULT_MAPPER;
		static ObjectMapper WRAPPED_MAPPER;
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
		}
		
		@Override
		public ObjectMapper getContext(Class<?> type) {
			return type.getAnnotation(JsonRootName.class) == null ? DEFAULT_MAPPER : WRAPPED_MAPPER;
		}
	}
}
