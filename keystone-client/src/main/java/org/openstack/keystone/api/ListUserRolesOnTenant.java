package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Roles;

public class ListUserRolesOnTenant implements KeystoneCommand<Roles> {
	
	private String tenantId;
	private String userId;
	
	public ListUserRolesOnTenant(String tenantId, String userId) {
		this.tenantId = tenantId;
		this.userId = userId;
	}

	@Override
	public Roles execute(WebTarget target) {
		return target.path("tenants").path(tenantId).path("users").path(userId).path("roles").request(MediaType.APPLICATION_JSON).get(Roles.class);
	}

}
