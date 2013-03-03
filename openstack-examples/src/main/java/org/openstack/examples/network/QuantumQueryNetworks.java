package org.openstack.examples.network;

import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.Authenticate;
import org.openstack.keystone.api.ListTenants;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Tenants;
import org.openstack.keystone.utils.KeystoneUtils;
import org.openstack.quantum.client.QuantumClient;
import org.openstack.quantum.model.Network;

public class QuantumQueryNetworks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KeystoneClient keystone = new KeystoneClient(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		// access with unscoped token
		Access access = keystone.execute(Authenticate.withPasswordCredentials(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD));
		// use the token in the following requests
		keystone.setToken(access.getToken().getId());

		Tenants tenants = keystone.execute(new ListTenants());
		// try to exchange token using the first tenant
		if (tenants.getList().size() > 0) {
			// access with tenant
			access = keystone.execute(Authenticate.withToken(access.getToken().getId())
					.withTenantId(tenants.getList().get(0).getId()));

			QuantumClient quantumClient = new QuantumClient(KeystoneUtils
					.findEndpointURL(access.getServiceCatalog(), "network",	null, "public"), 
					access.getToken().getId());

			Network networkQuery = new Network();
			networkQuery.setName("benn.cs");
			networkQuery.setAdminStateUp(true);
			/*
			Networks networks = quantumClient.execute(NetworkQuery.queryNetworks(networkQuery));

			for (Network network : networks) {
				System.out.println(network);
			}

			Subnet subnetQuery = new Subnet();
			subnetQuery.setIpversion(Subnet.IpVersion.IPV4);
			Subnets Subnets = quantumClient.execute(NetworkQuery.querySubnets(subnetQuery));
			for (Subnet subnet : Subnets) {
				System.out.println(subnet);
			}
			*/
		} else {
			System.out.println("No tenants found!");
		}
	}
}
