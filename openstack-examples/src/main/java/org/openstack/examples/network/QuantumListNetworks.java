package org.openstack.examples.network;

import org.openstack.base.client.OpenStackSimpleTokenProvider;
import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Tenants;
import org.openstack.keystone.utils.KeystoneUtils;
import org.openstack.quantum.QuantumClient;
import org.openstack.quantum.api.NetworkCore;
import org.openstack.quantum.model.Network;
import org.openstack.quantum.model.Networks;

public class QuantumListNetworks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		// access with unscoped token
		Access access = keystone.execute(Authenticate.withPasswordCredentials(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD));
		// use the token in the following requests
		keystone.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));

		Tenants tenants = keystone.tenants().list().execute();
		// try to exchange token using the first tenant
		if (tenants.getList().size() > 0) {
			// access with tenant
			access = keystone.execute(Authenticate.withToken(access.getToken().getId())
					.withTenantId(tenants.getList().get(0).getId()));

			QuantumClient quantumClient = new QuantumClient(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "network",	null, "public"));
			quantumClient.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));

			Networks networks = quantumClient.execute(NetworkCore.listNetworks());
			for (Network network : networks) {
				System.out.println(network);
			}
		} else {
			System.out.println("No tenants found!");
		}
	}
}
