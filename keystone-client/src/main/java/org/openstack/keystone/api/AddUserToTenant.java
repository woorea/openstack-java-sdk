package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;

public class AddUserToTenant implements KeystoneCommand<Void> {

	private String tenantId;
	private String userId;
	private String roleId;
	
	public AddUserToTenant(String tenantId, String userId, String roleId) {
		this.tenantId = tenantId;
		this.userId = userId;
		this.roleId = roleId;
	}
	
	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.PUT);
		request.path("/tenants").path(tenantId).path("/users").path(userId).path("/roles/OS-KSADM").path(roleId);
		request.entity(null,null);
		request.header("Accept", "application/json");
		return request;
		
	}

}
