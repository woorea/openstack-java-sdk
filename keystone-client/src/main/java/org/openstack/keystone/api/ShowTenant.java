package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Tenant;

public class ShowTenant extends OpenStackRequest {
	
	public ShowTenant(String id) {
		method(HttpMethod.GET);
		path("/tenants").path(id);
		header("Accept", "application/json");
		returnType(Tenant.class);
	}

	

}
