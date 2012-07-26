package org.openstack;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientFactory;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.ContextResolver;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.json.JsonJacksonFeature;

public class OpenStack {

	public static Client CLIENT;
	
	public static ObjectMapper DEFAULT_MAPPER;
	
	public static ObjectMapper WRAPPED_MAPPER;
	
	static {
		initialize();
	}
	
	private static void initialize() {
		
		CLIENT = ClientFactory.newClient();
		
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
		
		CLIENT.configuration().register(new JsonJacksonFeature()).register(new ContextResolver<ObjectMapper>() {

			public ObjectMapper getContext(Class<?> type) {
				return type.getAnnotation(JsonRootName.class) == null ? DEFAULT_MAPPER : WRAPPED_MAPPER;
			}
			
		});
		
		CLIENT.configuration().register(new ClientRequestFilter() {
			
			public void filter(ClientRequestContext requestContext) throws IOException {
				requestContext.getHeaders().remove("Content-Language");
				requestContext.getHeaders().remove("Content-Encoding");
			}
		});
		
		CLIENT.configuration().register(new LoggingFilter(Logger.getLogger("openstack"), true));
		
	}

}
