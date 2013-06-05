package com.woorea.openstack.examples.network;

import com.woorea.openstack.keystone.utils.KeystoneUtils;

import com.woorea.openstack.base.client.OpenStackSimpleTokenProvider;
import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.Tenants;
import com.woorea.openstack.keystone.model.authentication.TokenAuthentication;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;
import com.woorea.openstack.quantum.Quantum;
import com.woorea.openstack.quantum.model.Network;

public class QuantumQueryNetworks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Keystone keystone = new Keystone(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		// access with unscoped token
		Access access = keystone.tokens().authenticate(
				new UsernamePassword(ExamplesConfiguration.KEYSTONE_USERNAME, ExamplesConfiguration.KEYSTONE_PASSWORD))
				.execute();
		// use the token in the following requests
		keystone.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));

		Tenants tenants = keystone.tenants().list().execute();
		// try to exchange token using the first tenant
		if (tenants.getList().size() > 0) {
			// access with tenant
			access = keystone.tokens().authenticate(new TokenAuthentication(access.getToken().getId())).withTenantId(tenants.getList().get(0).getId()).execute();

			Quantum quantumClient = new Quantum(KeystoneUtils.findEndpointURL(access.getServiceCatalog(), "network",	null, "public"));
			quantumClient.setTokenProvider(new OpenStackSimpleTokenProvider(access.getToken().getId()));

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
