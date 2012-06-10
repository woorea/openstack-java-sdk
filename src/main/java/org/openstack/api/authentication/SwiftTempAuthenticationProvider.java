package org.openstack.api.authentication;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.ResponseHeaders;

import org.glassfish.jersey.filter.LoggingFilter;
import org.openstack.api.common.RestClient;

public class SwiftTempAuthenticationProvider extends AuthenticationProvider {

	public Properties authenticate(Properties properties) {
		LoggingFilter logging = new LoggingFilter();
		String account = properties.getProperty("storage.auth.account");
		String username = properties.getProperty("storage.auth.username");
		String password = properties.getProperty("storage.auth.password");
		String endpoint = properties.getProperty("storage.auth.endpoint");
		Target target = RestClient.INSTANCE.getJerseyClient().target(endpoint);
		target.configuration().register(logging);
		Response response = target.request(MediaType.WILDCARD)
			.header("X-Storage-User", account + ":" + username)
			.header("X-Storage-Pass", password)
			.get();
		ResponseHeaders headers = response.getHeaders();
		properties.setProperty("storage.endpoint", headers.getHeader("X-Storage-Url"));
		properties.setProperty("storage.token", headers.getHeader("X-Storage-Token"));
		properties.setProperty("auth.token", headers.getHeader("X-Auth-Token"));
		return properties;
	}
	
}
