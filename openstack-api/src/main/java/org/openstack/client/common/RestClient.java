package org.openstack.client.common;

import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.ext.ContextResolver;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientFactory;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.json.JsonFeature;
import org.openstack.client.imagestore.KnownLengthInputStreamProvider;
import org.openstack.client.internals.OpenstackSerializationModule;

public final class RestClient {

	public static final RestClient INSTANCE = new RestClient();
	
	final JerseyClient client;
	
	private RestClient() {
		
		client = (JerseyClient) JerseyClientFactory.newClient();
		
		client.configuration().enable(JsonFeature.getInstance());
		
		client.configuration().register(OpenstackJaxbContext.class);
		
        ObjectMapper objectMapper = buildObjectMapper();
        if (objectMapper != null) {
        	OpenstackSerializationModule simpleModule = new OpenstackSerializationModule();
            objectMapper.registerModule(simpleModule);
        	client.configuration().register(new ObjectMapperProvider(objectMapper));
        }
        
        
        
        client.configuration().register(KnownLengthInputStreamProvider.class);
	}
	
	public RestClient verbose(boolean verbose) {
		if(verbose) {
			client.configuration().register(new LoggingFilter(Logger.getLogger("org.openstack.model"),true));
		}
		return this;
	}
	
	Client getJerseyClient() {
		return client;
	}
	
	/**
     * Build a custom JSON ObjectMapper, or null if we should use default.
     * 
     * @return
     */
    private ObjectMapper buildObjectMapper() {
        // WRAP_ROOT_VALUE puts a top-level element in the JSON, and avoids having to use dummy objects
        ObjectMapper objectMapper = new ObjectMapper();

        {
            // If we want to put a top-level element in the JSON
            objectMapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
//            objectMapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
        }

        {
            // If we wanted to use a module for further customization...
            // SimpleModule module = new SimpleModule();
            // objectMapper.registerModule(module);
        }

        {
            // If we wanted to force UTC...
            // SerializationConfig serConfig = mapper.getSerializationConfig();
            // SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            // dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            //
            // serConfig.setDateFormat(dateFormat);
            //
            // DeserializationConfig deserializationConfig = mapper.getDeserializationConfig();
            // deserializationConfig.setDateFormat(dateFormat);
            //
            // mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        }

        {
            // Use Jackson annotations if they're present, otherwise use JAXB
            AnnotationIntrospector primary = new JacksonAnnotationIntrospector();
            AnnotationIntrospector secondary = new JaxbAnnotationIntrospector();
            AnnotationIntrospector introspector = new AnnotationIntrospector.Pair(primary, secondary);

            objectMapper.setAnnotationIntrospector(introspector);
        }

        return objectMapper;
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
	
}
