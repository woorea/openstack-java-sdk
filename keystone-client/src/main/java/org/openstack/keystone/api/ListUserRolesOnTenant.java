package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Roles;

public class ListUserRolesOnTenant extends OpenStackRequest {
	
	public ListUserRolesOnTenant(String tenantId, String userId) {
		method(HttpMethod.GET);
		path("/tenants").path(tenantId).path("/users").path(userId).path("/roles");
		header("Accept", "application/json");
		returnType(Roles.class);
	}

}
