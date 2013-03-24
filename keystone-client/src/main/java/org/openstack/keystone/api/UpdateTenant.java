package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Tenant;

public class UpdateTenant implements KeystoneCommand<Tenant> {

	private Tenant tenant;
	
	public UpdateTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Override
	public Tenant execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("GET");
		request.path("/tenants").path(tenant.getId());
		request.header("Accept", "application/json");
		return connector.execute(request, Tenant.class);
		//return target.path("tenants").path(tenant.getId()).request(MediaType.APPLICATION_JSON).put(Entity.json(tenant), Tenant.class);
	}
	
}
