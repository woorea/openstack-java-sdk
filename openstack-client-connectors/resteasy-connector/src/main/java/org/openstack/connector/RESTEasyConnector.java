package org.openstack.connector;

import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ContextResolver;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

import com.google.common.reflect.TypeToken;

public class RESTEasyConnector implements OpenStackClientConnector {

	public static ObjectMapper DEFAULT_MAPPER;

	public static ObjectMapper WRAPPED_MAPPER;

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

		ResteasyProviderFactory.getInstance().addContextResolver(new ContextResolver<ObjectMapper>() {
			public ObjectMapper getContext(Class<?> type) {
				return type.getAnnotation(JsonRootName.class) == null ? DEFAULT_MAPPER : WRAPPED_MAPPER;
			}
		});
	}

	@Override
	public <T> T execute(OpenStackRequest request, Class<T> responseType) {
		ClientRequest client = new ClientRequest(request.endpoint() + "/" + request.path());

		for(Entry<String, List<Object>> h : request.headers().entrySet()) {
			StringBuilder sb = new StringBuilder();
			for(Object v : h.getValue()) {
				sb.append(String.valueOf(v));
			}
			client.header(h.getKey(), sb);
		}

		if(request.entity() != null) {
			client.body(request.entity().getContentType(), request.entity().getEntity());
		}

		try {
			return (T) client.httpMethod(request.method(), responseType).getEntity(responseType);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void execute(OpenStackRequest request) {
		execute(request, Response.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T execute(OpenStackRequest request, TypeToken<T> typeToken) {
		return (T) execute(request, typeToken.getClass());
	}

}
