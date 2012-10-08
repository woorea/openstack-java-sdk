package org.openstack.keystone.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
	public Void execute(WebTarget target) {
		target.path("tenants").path(tenantId).path("users").path(userId).path("roles/OS-KSADM").path(roleId).request(MediaType.APPLICATION_JSON).put(Entity.json("{}"));
		return null;
	}

}
