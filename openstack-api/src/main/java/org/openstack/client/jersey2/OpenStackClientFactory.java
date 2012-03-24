package org.openstack.client.jersey2;

import javax.ws.rs.client.Client;

import org.openstack.api.common.RestClient;
import org.openstack.api.identity.IdentityResource;
import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;

public class OpenStackClientFactory {

	public static OpenStackClient authenticate(String authURL, String username, String password, String tenantName) {
		Client client = RestClient.INSTANCE.verbose(true).getJerseyClient();
		KeystoneAuthentication authentication = new KeystoneAuthentication().withPasswordCredentials(username, password);
		authentication.setTenantName(tenantName);
		IdentityResource auth = new IdentityResource(client.target(authURL));
		KeystoneAccess access = auth.tokens().post(authentication);
		OpenStackClient openstack = new OpenStackClient(client, authURL, access);
		return openstack;
	}
	
	public static OpenStackClient authenticate(String authURL, String username, String password) {
		return authenticate(authURL, username, password, null);
		
	}

	public static OpenStackClient create(KeystoneAccess access) {
		Client client = RestClient.INSTANCE.verbose(true).getJerseyClient();
		return new OpenStackClient(client, null, access);
	}
	
}
