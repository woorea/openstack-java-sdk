package org.openstack.keystone.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Role;

public class UpdateRole implements KeystoneCommand<Role> {

	private Role roleForCreate;
	
	public UpdateRole(Role roleForCreate) {
		this.roleForCreate = roleForCreate;
	}

	@Override
	public Role execute(WebTarget target) {
		return target.path("OS-KSADM/roles").request(MediaType.APPLICATION_JSON).put(Entity.json(roleForCreate), Role.class);
	}
	
}
