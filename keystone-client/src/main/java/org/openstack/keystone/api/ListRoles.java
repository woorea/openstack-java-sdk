package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Roles;

public class ListRoles implements KeystoneCommand<Roles>{

	@Override
	public Roles execute(WebTarget target) {
		return target.path("OS-KSADM/roles").request(MediaType.APPLICATION_JSON).get(Roles.class);
	}

}
