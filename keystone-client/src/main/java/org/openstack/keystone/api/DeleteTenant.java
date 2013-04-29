package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;

public class DeleteTenant extends OpenStackRequest {
	
	public DeleteTenant(String id) {
		method(HttpMethod.DELETE);
	    path("/tenants/").path(id);
	    header("Accept", "application/json");
	}
	
}
