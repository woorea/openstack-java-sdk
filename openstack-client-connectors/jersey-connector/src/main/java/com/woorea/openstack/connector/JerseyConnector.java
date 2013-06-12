package com.woorea.openstack.connector;

import java.util.List;
import java.util.Map;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.base.client.OpenStackRequest;
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
	public <T> T execute(OpenStackRequest<T> request) {
		WebResource target = client.resource(request.endpoint()).path(request.path());
		for(Map.Entry<String, List<Object> > entry : request.queryParams().entrySet()) {
			for (Object o : entry.getValue()) {
				target = target.queryParam(entry.getKey(), String.valueOf(o));
			}
		}
		target.addFilter(new LoggingFilter());
		
		WebResource.Builder tb = target.getRequestBuilder();
		for(Map.Entry<String, List<Object>> h : request.headers().entrySet()) {
			StringBuilder sb = new StringBuilder();
			for(Object v : h.getValue()) {
				sb.append(String.valueOf(v));
			}
			tb.header(h.getKey(), sb);
		}
		if(request.entity() != null && request.entity().getContentType() != null) {
			tb.header("Content-Type", request.entity().getContentType());
		} else {
			tb.header("Content-Type", "application/json");
		}
		try {
			if (request.entity() != null && request.entity().getEntity() != null) {
				if (request.returnType() == null || Void.class == request.returnType()) {
					tb.method(request.method().name(), request.entity().getEntity());
				} else {
					return tb.method(request.method().name(), request.returnType(), request.entity().getEntity());
				}
			} else {
				if (request.returnType() == null || Void.class == request.returnType()) {
					tb.method(request.method().name());
				} else {
					return tb.method(request.method().name(), request.returnType());
				}
			}
		} catch (UniformInterfaceException e) {
			throw new OpenStackResponseException(e.getResponse().getClientResponseStatus().getReasonPhrase(), e.getResponse().getStatus());
		}
		return null;
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
