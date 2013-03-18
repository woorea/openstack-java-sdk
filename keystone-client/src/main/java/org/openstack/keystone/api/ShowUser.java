package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.User;

public class ShowUser implements KeystoneCommand<User>{
	
	private String id;
	
	public ShowUser(String id) {
		this.id = id;
	}

	@Override
	public User execute(WebTarget target) {
		return target.path("users").path(id).request(MediaType.APPLICATION_JSON).get(User.class);
	}

}
