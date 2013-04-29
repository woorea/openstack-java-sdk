package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Tenant;

public class CreateTenant extends OpenStackRequest {

	private Tenant tenant;
	
	public CreateTenant(Tenant tenant) {
		this.tenant = tenant;
		
		method(HttpMethod.POST);
		path("/tenants");
		json(tenant);
		header("Accept", "application/json");
		returnType(Tenant.class);
	}
	
}
