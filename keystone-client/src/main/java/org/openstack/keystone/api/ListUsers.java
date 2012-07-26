package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Users;

public class ListUsers implements KeystoneCommand<Users>{

	@Override
	public Users execute(WebTarget target) {
		return target.path("users").request(MediaType.APPLICATION_JSON).get(Users.class);
	}

}
