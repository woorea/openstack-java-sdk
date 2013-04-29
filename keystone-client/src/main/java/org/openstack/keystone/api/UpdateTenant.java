package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Tenant;

public class UpdateTenant extends OpenStackRequest {

	private Tenant tenant;
	
	public UpdateTenant(Tenant tenant) {
		this.tenant = tenant;
		
		method(HttpMethod.PUT);
		path("/tenants").path(tenant.getId());
		header("Accept", "application/json");
		returnType(Tenant.class);
	}
	
}
