package org.openstack.examples.compute;

import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.api.ListTenants;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Authentication;
import org.openstack.keystone.model.Authentication.PasswordCredentials;
import org.openstack.keystone.model.Authentication.Token;
import org.openstack.keystone.model.Tenants;
import org.openstack.keystone.utils.KeystoneUtils;
import org.openstack.nova.NovaClient;
import org.openstack.nova.api.ServersCore;
import org.openstack.nova.model.Server;
import org.openstack.nova.model.Servers;

public class NovaListServers {
	
	private static final String KEYSTONE_AUTH_URL = "";
	
	private static final String KEYSTONE_USERNAME = "";
	
	private static final String KEYSTONE_PASSWORD = "";
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(KEYSTONE_AUTH_URL);
		Authentication authentication = new Authentication();
		PasswordCredentials passwordCredentials = new PasswordCredentials();
		passwordCredentials.setUsername(KEYSTONE_USERNAME);
		passwordCredentials.setPassword(KEYSTONE_PASSWORD);
		authentication.setPasswordCredentials(passwordCredentials);
		
		//access with unscoped token
		Access access = keystone.execute(new Authenticate(authentication));
		
		//use the token in the following requests
		keystone.setToken(access.getToken().getId());
		
		Tenants tenants = keystone.execute(new ListTenants());
		
		//try to exchange token using the first tenant
		if(tenants.getList().size() > 0) {
			
			authentication = new Authentication();
			Token token = new Token();
			token.setId(access.getToken().getId());
			authentication.setToken(token);
			authentication.setTenantId(tenants.getList().get(0).getId());
			
			access = keystone.execute(new Authenticate(authentication));
			
			NovaClient novaClient = new NovaClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "compute", null, "public"), access.getToken().getId());
			
			Servers servers = novaClient.execute(ServersCore.listServers());
			for(Server server : servers) {
				System.out.println(server);
			}
			
		} else {
			System.out.println("No tenants found!");
		}
		
	}

}
