package com.woorea.openstack.examples.compute;


import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;
import com.woorea.openstack.nova.Nova;
import com.woorea.openstack.nova.model.Service;
import com.woorea.openstack.nova.model.Services;

public class NovaListServices {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Keystone keystone = new Keystone(/*"http://10.0.2.15:5000/v2.0"); */ExamplesConfiguration.KEYSTONE_AUTH_URL);
		Access access = keystone.tokens().authenticate(
			new UsernamePassword(/*"admin", */ExamplesConfiguration.KEYSTONE_USERNAME,
				/*"nomoresecrete"))*/ExamplesConfiguration.KEYSTONE_PASSWORD))
			.withTenantName(/*"admin")*/"demo")
			.execute();
		
		//use the token in the following requests
		keystone.token(access.getToken().getId());
			
		//NovaClient novaClient = new NovaClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "compute", null, "public"), access.getToken().getId());
		Nova novaClient = new Nova(/*"http://10.0.2.15:8774/v2/" + access.getToken().getTenant().getId());*/ExamplesConfiguration.NOVA_ENDPOINT.concat("/").concat(access.getToken().getTenant().getId()));
		novaClient.token(access.getToken().getId());
		//novaClient.enableLogging(Logger.getLogger("nova"), 100 * 1024);

		Services services = novaClient.services().list(false).execute();
		for(Service service : services) {
			System.out.println(service);

			/*
			if ("nova-compute".equals(service.getBinary())) {
				final Service disabledService = novaClient.services().disable(service.getHost(), service.getBinary()).execute();
				System.out.println("Disabled: " + disabledService);
				try { Thread.sleep(5000); } catch (final Exception ex) { }
				final Service enabedService = novaClient.services().enable(service.getHost(), service.getBinary()).execute();
				System.out.println("Enabled: " + enabedService);
			}
			*/
		}
		
	}

}
