package org.openstack.client;

import java.io.IOException;
import java.util.Properties;

import org.openstack.api.common.RestClient;
import org.openstack.api.identity.IdentityPublicEndpoint;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;

public class OpenStackClientFactory {
	
	public static OpenStackClient authenticate() {
		try {
			Properties properties = new Properties();
			properties.load(OpenStackClient.class.getResourceAsStream("/openstack.properties"));
			return authenticate(properties);
		} catch (IOException e) {
			throw new OpenstackException("openstack.properties not found in the CLASSPATH", e);
		}
	}
	
	public static OpenStackClient authenticate(Properties properties) {
		String endpoint = properties.getProperty("auth.endpoint");
		String username = properties.getProperty("auth.username");
		String password = properties.getProperty("auth.password");
		String tenantId = properties.getProperty("auth.tenant.id");
		String tenantName = properties.getProperty("auth.tenant.name");
		KeystoneAuthentication authentication = new KeystoneAuthentication().withPasswordCredentials(username, password);
		if(tenantId != null) {
			authentication.setTenantId(tenantId);
		} else if(tenantName != null) {
			authentication.setTenantName(tenantName);
		}
		IdentityPublicEndpoint auth = new IdentityPublicEndpoint(RestClient.INSTANCE.getJerseyClient().target(endpoint));
		KeystoneAccess access = auth.tokens().post(authentication);
		OpenStackClient openstack = new OpenStackClient(properties, access);
		return openstack;
	}

	public static OpenStackClient create(Properties properties, KeystoneAccess access) {
		return new OpenStackClient(properties, access);
	}

}
