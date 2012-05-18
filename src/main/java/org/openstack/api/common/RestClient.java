package org.openstack.api.common;

import javax.ws.rs.client.Client;
import javax.ws.rs.ext.ContextResolver;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientFactory;
import org.glassfish.jersey.media.json.JsonJacksonFeature;

public enum RestClient {

	INSTANCE;
	
	private JerseyClient client;
	
	private RestClient() {
		
		//
		
		client = (JerseyClient) JerseyClientFactory.newClient();
		
		client.configuration().enable(new JsonJacksonFeature());
		
		client.configuration().register(new OpenstackExceptionClientFilter());
		
		client.configuration().register(OpenStackObjectMapperProvider.class);
		
		//client.configuration().register(JaxbContextResolver.class);
		
		//client.configuration().register(OpenstackJaxbContext.class);
		
	}
	
	public Client getJerseyClient() {
		return client;
	}
    
    public static final class OpenstackJaxbContext implements ContextResolver<JAXBContext> {
    	
    	private JAXBContext ctx;
    	
    	public OpenstackJaxbContext() {
    		try {
				ctx = JAXBContext.newInstance("org.openstack.model.identity:org.openstack.model.compute");
			} catch (JAXBException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
    	}

		@Override
		public JAXBContext getContext(Class<?> type) {
			return ctx;
		}
    	
    }
    
    public static final class OpenStackObjectMapperProvider implements ContextResolver<ObjectMapper> {
    	
    	private final ObjectMapper objectMapper;
    	
    	public OpenStackObjectMapperProvider() {
    		objectMapper = new ObjectMapper();
    		objectMapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
    		objectMapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
    		objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            AnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
            objectMapper.setDeserializationConfig(objectMapper.getDeserializationConfig().withAnnotationIntrospector(introspector));
            objectMapper.setSerializationConfig(objectMapper.getSerializationConfig().withSerializationInclusion(Inclusion.NON_NULL).withAnnotationIntrospector(introspector));
    	}

		@Override
		public ObjectMapper getContext(Class<?> type) {
			JsonRootName jsonRootName = type.getAnnotation(JsonRootName.class);
			objectMapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, jsonRootName != null);
			return objectMapper;
		}
    	
    }
	
}
