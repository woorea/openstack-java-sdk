package org.openstack.examples.compute;

import org.openstack.base.client.OpenStackSimpleTokenProvider;
import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.Keystone;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Authentication;
import org.openstack.keystone.model.Authentication.PasswordCredentials;
import org.openstack.keystone.model.Authentication.Token;
import org.openstack.keystone.model.Tenants;
import org.openstack.nova.Nova;
import org.openstack.nova.model.Flavor;
import org.openstack.nova.model.Flavors;

public class NovaListFlavors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		Authentication authentication = new Authentication();
		PasswordCredentials passwordCredentials = new PasswordCredentials();
		passwordCredentials.setUsername(ExamplesConfiguration.KEYSTONE_USERNAME);
		passwordCredentials.setPassword(ExamplesConfiguration.KEYSTONE_PASSWORD);
		authentication.setPasswordCredentials(passwordCredentials);
		
		//access with unscoped token
		Access access = keystone.execute(new Authenticate(authentication));
		
		//use the token in the following requests
		keystone.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));
		
		Tenants tenants = keystone.tenants().list().execute();
		
		//try to exchange token using the first tenant
		if(tenants.getList().size() > 0) {
			
			authentication = new Authentication();
			Token token = new Token();
			token.setId(access.getToken().getId());
			authentication.setToken(token);
			authentication.setTenantId(tenants.getList().get(0).getId());
			
			access = keystone.execute(new Authenticate(authentication));
			
			//NovaClient novaClient = new NovaClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "compute", null, "public"), access.getToken().getId());
			Nova novaClient = new Nova(ExamplesConfiguration.NOVA_ENDPOINT.concat(tenants.getList().get(0).getId()));
			novaClient.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));
			//novaClient.enableLogging(Logger.getLogger("nova"), 100 * 1024);
			
			Flavors flavors = novaClient.flavors().list(true).execute();
			for(Flavor flavor : flavors) {
				System.out.println(flavor);
			}
			
		} else {
			System.out.println("No tenants found!");
		}
		
	}

}
