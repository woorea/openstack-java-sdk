package org.openstack.client.common;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.openstack.client.imagestore.KnownLengthInputStreamProvider;
import org.openstack.client.internals.OpenstackSerializationModule;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import org.codehaus.jackson.map.SerializationConfig;

public final class JerseyClient {

	public static final JerseyClient INSTANCE = new JerseyClient();
	
	final Client client;
	
	private JerseyClient() {
		ClientConfig config = new DefaultClientConfig();

        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

        ObjectMapper objectMapper = buildObjectMapper();
        if (objectMapper != null) {
            config.getSingletons().add(new ObjectMapperProvider(objectMapper));
        }

        OpenstackSerializationModule simpleModule = new OpenstackSerializationModule();
        objectMapper.registerModule(simpleModule);

        config.getClasses().add(KnownLengthInputStreamProvider.class);

        client = Client.create(config);

        client.addFilter(new OpenstackExceptionClientFilter());
	}
	
	public JerseyClient verbose(boolean verbose) {
		if(verbose) {
			client.addFilter(new LoggingFilter(System.out));
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
	
}
