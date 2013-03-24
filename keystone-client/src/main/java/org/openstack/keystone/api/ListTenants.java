package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Tenants;

public class ListTenants implements KeystoneCommand<Tenants>{

	@Override
	public Tenants execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("GET");
		request.path("/tenants");
		request.header("Accept", "application/json");
		return connector.execute(request, Tenants.class);
		//return target.path("tenants").request(MediaType.APPLICATION_JSON).get(Tenants.class);
	}

}
