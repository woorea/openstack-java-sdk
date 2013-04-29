package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;

public class AddUserToTenant extends OpenStackRequest {
	
	public AddUserToTenant(String tenantId, String userId, String roleId) {
		method(HttpMethod.PUT);
		path("/tenants").path(tenantId).path("/users").path(userId).path("/roles/OS-KSADM").path(roleId);
		entity(null,null);
		header("Accept", "application/json");
	}

}
