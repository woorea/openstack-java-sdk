package org.openstack.api.common;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.ext.ContextResolver;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientFactory;
import org.glassfish.jersey.filter.LoggingFilter;

public enum RestClient {

	INSTANCE;
	
	private static final Logger LOGGER = Logger.getLogger("org.glassfish");
	
	private JerseyClient client;
	
	private RestClient() {
		
		//
		
		client = (JerseyClient) JerseyClientFactory.newClient();
		
		//client.configuration().enable(JsonFeature.getInstance());
		
		client.configuration().register(GsonProvider.class);
		
		//client.configuration().register(ObjectMapperProvider.class);
		
		//client.configuration().register(OpenstackJaxbContext.class);
		
		/*
        ObjectMapper objectMapper = buildObjectMapper();
        if (objectMapper != null) {
        	OpenstackSerializationModule simpleModule = new OpenstackSerializationModule();
            objectMapper.registerModule(simpleModule);
        	client.configuration().register(new ObjectMapperProvider(objectMapper));
        }
       
        
        
        client.configuration().register(KnownLengthInputStreamProvider.class);
         */
	}
	
	public RestClient verbose(boolean verbose) {
		if(verbose) {
			LOGGER.setLevel(Level.FINEST);
			client.configuration().register(new LoggingFilter(LOGGER,false));
		}
		return this;
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
	
}
