package com.woorea.openstack.examples.network;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.woorea.openstack.keystone.utils.KeystoneUtils;

import com.woorea.openstack.base.client.OpenStackSimpleTokenProvider;
import com.woorea.openstack.examples.ExamplesConfiguration;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.Tenant;
import com.woorea.openstack.keystone.model.Tenants;
import com.woorea.openstack.keystone.model.authentication.TokenAuthentication;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;
import com.woorea.openstack.quantum.Quantum;
import com.woorea.openstack.quantum.api.NetworksResource;
import com.woorea.openstack.quantum.api.NetworksResource.Create;
import com.woorea.openstack.quantum.model.Network;
import com.woorea.openstack.quantum.model.NetworkForCreate;
import com.woorea.openstack.quantum.model.Networks;
import com.woorea.openstack.quantum.model.Port;
import com.woorea.openstack.quantum.model.PortForCreate;
import com.woorea.openstack.quantum.model.Router;
import com.woorea.openstack.quantum.model.RouterForAddInterface;
import com.woorea.openstack.quantum.model.RouterForCreate;
import com.woorea.openstack.quantum.model.Subnet;
import com.woorea.openstack.quantum.model.SubnetForCreate;
import com.woorea.openstack.quantum.model.Subnets;

public class QuantumNetworkCreate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Keystone keystone = new Keystone(
				ExamplesConfiguration.KEYSTONE_AUTH_URL);
		// access with unscoped token
		Access access = keystone
				.tokens()
				.authenticate(
						new UsernamePassword(
								ExamplesConfiguration.KEYSTONE_USERNAME,
								ExamplesConfiguration.KEYSTONE_PASSWORD))
				.execute();
		// use the token in the following requests
		keystone.setTokenProvider(new OpenStackSimpleTokenProvider(access
				.getToken().getId()));
		keystone.token(access.getToken().getId());
		Tenants tenants = keystone.tenants().list().execute();
		// try to exchange token using the first tenant

		if (tenants.getList().size() > 0) {
			// access with tenant
			Network network = new Network();
			access = keystone
					.tokens()
					.authenticate(
							new TokenAuthentication(access.getToken().getId()))
					.withTenantId("tenantId").execute();
			Quantum quantum = new Quantum(KeystoneUtils.findEndpointURL(
					access.getServiceCatalog(), "network", null, "public"));
			quantum.setTokenProvider(new OpenStackSimpleTokenProvider(access
					.getToken().getId()));
			NetworkForCreate netcreate = new NetworkForCreate();
			netcreate.setTenantId("tenantId");
			netcreate.setName("net2");
			netcreate.setAdminStateUp(true);

			network = quantum.networks().create(netcreate).execute();

			// Creating Subnet
			try {
				Subnet sub = new Subnet();
				SubnetForCreate subnet = new SubnetForCreate();
				subnet.setCidr("");
				subnet.setName("");
				subnet.setNetworkId(network.getId());
				subnet.setIpVersion(4);
				sub = quantum.subnets().create(subnet).execute();
				RouterForCreate routerForCreate = new RouterForCreate();
				routerForCreate.setName("routerName");
				routerForCreate.setTenantId("tenantId");
				Router router = quantum.routers().create(routerForCreate)
						.execute();
				RouterForAddInterface routerForAdd = new RouterForAddInterface();
				routerForAdd.setSubnetId(sub.getId());
				routerForAdd.setRouterId(router.getId());
				quantum.routers().addInterface(routerForAdd).execute();

				// System.out.println(sub);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			Networks networks = quantum.networks().list().execute();

			for (Network network1 : networks) {
				System.out.println(network1);
			}
		} else {
			System.out.println("No tenants found!");
		}

	}
}
