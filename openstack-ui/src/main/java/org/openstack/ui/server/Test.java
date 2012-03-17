package org.openstack.ui.server;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.RequestFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientFactory;
import org.glassfish.jersey.filter.LoggingFilter;
import org.openstack.model.identity.KeyStoneAuthentication;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		Logger log = Logger.getLogger(LoggingFilter.class.getName());
		
		KeyStoneAuthentication authentication = new KeyStoneAuthentication();
		authentication.withPasswordCredentials("demo", "secret0");
		
		JerseyClient client = (JerseyClient) JerseyClientFactory.newClient();
		client.configuration().register(new JAXBContextResolver());
		client.configuration().register(new LoggingFilter(log, true));
		String access = client.target("http://192.168.1.45:5000/v2.0").path("/tokens")
			.request(MediaType.APPLICATION_XML)
			.post(Entity.xml(authentication), String.class);
		System.out.println(access);

	}
	
	public static class JAXBContextResolver implements ContextResolver<JAXBContext> {
		
		private JAXBContext ctx;
		
		public JAXBContextResolver() {
			try {
				ctx = JAXBContext.newInstance(KeyStoneAuthentication.class);
			} catch (JAXBException e) {
				throw new RuntimeException(e.getMessage(),e);
			}
		}

		@Override
		public JAXBContext getContext(Class<?> type) {
			return ctx;
		}
		
	}

}
