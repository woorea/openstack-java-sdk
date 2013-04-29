package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class RemoveUserFromTenant implements OpenStackCommand<Void> {

	private String tenantId;
	private String userId;
	private String roleId;
	
	public RemoveUserFromTenant(String tenantId, String userId, String roleId) {
		this.tenantId = tenantId;
		this.userId = userId;
		this.roleId = roleId;
	}
	
	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.DELETE);
		request.path("tenants").path(tenantId).path("users").path(userId).path("roles/OS-KSADM").path(roleId);
		request.header("Accept", "application/json");
		//target.path("tenants").path(tenantId).path("users").path(userId).path("roles/OS-KSADM").path(roleId).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}

}
