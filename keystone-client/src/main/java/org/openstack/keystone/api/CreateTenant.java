package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Tenant;

public class CreateTenant implements OpenStackCommand<Tenant> {

	private Tenant tenant;
	
	public CreateTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.POST);
		request.path("/tenants");
		request.json(tenant);
		request.header("Accept", "application/json");
		request.returnType(Tenant.class);
		return request;
		//return target.path("tenants").request(MediaType.APPLICATION_JSON).post(Entity.json(tenant), Tenant.class);
	}
	
}
