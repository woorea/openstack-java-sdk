package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Tenant;

public class ShowTenant implements KeystoneCommand<Tenant>{
	
	private String id;
	
	public ShowTenant(String id) {
		this.id = id;
	}

	@Override
	public Tenant execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("GET");
		request.path("/tenants").path(id);
		request.header("Accept", "application/json");
		return connector.execute(request, Tenant.class);
		//return target.path("tenants").path(id).request(MediaType.APPLICATION_JSON).get(Tenant.class);
	}

}
