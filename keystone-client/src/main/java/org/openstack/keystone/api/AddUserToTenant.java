package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
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
	public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("PUT");
		request.path("/tenants").path(tenantId).path("/users").path(userId).path("/roles/OS-KSADM").path(roleId);
		request.entity(null,null);
		request.header("Accept", "application/json");
		connector.execute(request);
		return null;
		//target.path("tenants").path(tenantId).path("users").path(userId).path("roles/OS-KSADM").path(roleId).request(MediaType.APPLICATION_JSON).put(Entity.json("{}"));
		
	}

}
