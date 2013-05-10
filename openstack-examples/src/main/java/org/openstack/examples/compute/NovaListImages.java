package org.openstack.examples.compute;

import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.Keystone;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Tenants;
import org.openstack.keystone.model.authentication.TokenAuthentication;
import org.openstack.keystone.model.authentication.UsernamePassword;
import org.openstack.nova.Nova;
import org.openstack.nova.model.Image;
import org.openstack.nova.model.Images;

public class NovaListImages {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		Access access = keystone.tokens().authenticate(new UsernamePassword(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD)).execute();
		
		//use the token in the following requests
		keystone.token(access.getToken().getId());
		
		Tenants tenants = keystone.tenants().list().execute();
		
		//try to exchange token using the first tenant
		if(tenants.getList().size() > 0) {
			
			access = keystone.tokens().authenticate(new TokenAuthentication(access.getToken().getId()))
					.withTenantId(tenants.getList().get(0).getId())
					.execute();
			
			//NovaClient novaClient = new NovaClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "compute", null, "public"), access.getToken().getId());
			Nova novaClient = new Nova(ExamplesConfiguration.NOVA_ENDPOINT.concat("/").concat(tenants.getList().get(0).getId()));
			novaClient.token(access.getToken().getId());
			//novaClient.enableLogging(Logger.getLogger("nova"), 100 * 1024);
			
			Images images = novaClient.images().list(true).execute();
			for(Image image : images) {
				System.out.println(image);
			}
			
		} else {
			System.out.println("No tenants found!");
		}
		
	}

}
