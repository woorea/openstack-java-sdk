package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;

public class RemoveUserFromTenant extends OpenStackRequest {

	private String tenantId;
	private String userId;
	private String roleId;
	
	public RemoveUserFromTenant(String tenantId, String userId, String roleId) {
		method(HttpMethod.DELETE);
		path("tenants").path(tenantId).path("users").path(userId).path("roles/OS-KSADM").path(roleId);
		header("Accept", "application/json");
		//target.path("tenants").path(tenantId).path("users").path(userId).path("roles/OS-KSADM").path(roleId).request(MediaType.APPLICATION_JSON).delete();
	}

}
