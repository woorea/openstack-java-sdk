package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Tenant;

public class CreateTenant implements KeystoneCommand<Tenant> {

	private Tenant tenant;
	
	public CreateTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Override
	public Tenant execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("POST");
		request.path("/tenants");
		request.json(tenant);
		request.header("Accept", "application/json");
		return connector.execute(request, Tenant.class);
		//return target.path("tenants").request(MediaType.APPLICATION_JSON).post(Entity.json(tenant), Tenant.class);
	}
	
}
