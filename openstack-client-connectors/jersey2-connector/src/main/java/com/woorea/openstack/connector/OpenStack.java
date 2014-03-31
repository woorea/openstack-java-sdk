package com.woorea.openstack.connector;

import java.io.IOException;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.SslConfigurator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class OpenStack {

	public static Client CLIENT;
	
	public static ObjectMapper DEFAULT_MAPPER;
	
	public static ObjectMapper WRAPPED_MAPPER;
	
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
            
            SslConfigurator sslConfig = SslConfigurator.newInstance();
            		/*
                    .trustStoreFile("./truststore_client")
                    .trustStorePassword("asdfgh")

                    .keyStoreFile("./keystore_client")
                    .keyPassword("asdfgh");
                    */
            		//old: CLIENT.property(ClientProperties.SSL_CONFIG, new SslConfig(context));
            
            CLIENT = ClientBuilder.newBuilder().sslContext(sslConfig.createSSLContext()).build();
			
			DEFAULT_MAPPER = new ObjectMapper();
			
			DEFAULT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			DEFAULT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
			DEFAULT_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			DEFAULT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			
			WRAPPED_MAPPER = new ObjectMapper();
			
			WRAPPED_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			WRAPPED_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
			WRAPPED_MAPPER.enable(SerializationFeature.WRAP_ROOT_VALUE);
			WRAPPED_MAPPER.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
			WRAPPED_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
			WRAPPED_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			
			CLIENT.register(new JacksonFeature()).register(new ContextResolver<ObjectMapper>() {

				public ObjectMapper getContext(Class<?> type) {
					return type.getAnnotation(JsonRootName.class) == null ? DEFAULT_MAPPER : WRAPPED_MAPPER;
				}
				
			});
			
			CLIENT.register(new ClientRequestFilter() {
				
				public void filter(ClientRequestContext requestContext) throws IOException {
					requestContext.getHeaders().remove("Content-Language");
					requestContext.getHeaders().remove("Content-Encoding");
				}
			});
			
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}

}
