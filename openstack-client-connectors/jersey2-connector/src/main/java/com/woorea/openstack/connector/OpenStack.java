package com.woorea.openstack.connector;

import java.io.IOException;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.ContextResolver;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.glassfish.jersey.SslConfigurator;
import org.glassfish.jersey.jackson.JacksonFeature;

public class OpenStack {

	public static ObjectMapper DEFAULT_MAPPER;
	
	public static ObjectMapper WRAPPED_MAPPER;

	private static SslConfigurator sslConfig;

	static {
		initialize();
	}
	
	private static void initialize() {
		
		/*
		//class MyX509TrustManager implements X509TrustManager
		TrustManager mytm[] = null;
        KeyManager mykm[] = null;

        try {
            mytm = new TrustManager[]{new MyX509TrustManager("./truststore_client", "asdfgh".toCharArray())};
            mykm = new KeyManager[]{new MyX509KeyManager("./keystore_client", "asdfgh".toCharArray())};
        } catch (Exception ex) {

        }
		
		SSLContext context = null;
        context = SSLContext.getInstance("SSL");
        context.init(mykm, mytm, null);
		
		*/
		
		try {
			
			SSLContext context = null;
            context = SSLContext.getInstance("SSL");
            context.init(null, null, null);
            
            sslConfig = SslConfigurator.newInstance();
            		/*
                    .trustStoreFile("./truststore_client")
                    .trustStorePassword("asdfgh")

                    .keyStoreFile("./keystore_client")
                    .keyPassword("asdfgh");
                    */
            		//old: CLIENT.property(ClientProperties.SSL_CONFIG, new SslConfig(context));
            
			DEFAULT_MAPPER = new ObjectMapper();
			
			DEFAULT_MAPPER.setSerializationInclusion(Inclusion.NON_NULL);
			DEFAULT_MAPPER.enable(SerializationConfig.Feature.INDENT_OUTPUT);
			DEFAULT_MAPPER.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			DEFAULT_MAPPER.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
			
			WRAPPED_MAPPER = new ObjectMapper();
			
			WRAPPED_MAPPER.setSerializationInclusion(Inclusion.NON_NULL);
			WRAPPED_MAPPER.enable(SerializationConfig.Feature.INDENT_OUTPUT);
			WRAPPED_MAPPER.enable(SerializationConfig.Feature.WRAP_ROOT_VALUE);
			WRAPPED_MAPPER.enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);
			WRAPPED_MAPPER.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			WRAPPED_MAPPER.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private static class CustomContextResolver implements ContextResolver<ObjectMapper> {
		public ObjectMapper getContext(Class<?> type) {
			return type.getAnnotation(JsonRootName.class) == null ? DEFAULT_MAPPER : WRAPPED_MAPPER;
		}
	}

	private static final CustomContextResolver CONTEXT_RESOLVER = new CustomContextResolver();

	private static class ContentHeaderFilter implements ClientRequestFilter {
		public void filter(ClientRequestContext requestContext) throws IOException {
			requestContext.getHeaders().remove("Content-Language");
			requestContext.getHeaders().remove("Content-Encoding");
		}
	}

	private static final ContentHeaderFilter HEADER_FILTER = new ContentHeaderFilter();

	private static final JacksonFeature JACKSON_FEATURE = new JacksonFeature();

	public static Client newClient() {
		Client client = ClientBuilder.newBuilder().sslContext(sslConfig.createSSLContext()).build();
		client.register(JACKSON_FEATURE).register(CONTEXT_RESOLVER);
		client.register(HEADER_FILTER);
		return client;
	}
}
