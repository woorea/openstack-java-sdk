package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Users;

public class ListUsersOnTenant extends OpenStackRequest {
	
	public ListUsersOnTenant(String tenantId) {
		method(HttpMethod.GET);
		path("tenants").path(tenantId).path("users");
		header("Accept", "application/json");
		returnType(Users.class);
	}

}
