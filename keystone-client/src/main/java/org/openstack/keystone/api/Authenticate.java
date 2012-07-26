package org.openstack.keystone.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Authentication;

public class Authenticate implements KeystoneCommand<Access> {
	
	private Authentication authentication;
	
	public Authenticate(Authentication authentication) {
		this.authentication = authentication;
	}

	@Override
	public Access execute(WebTarget target) {
		return target.path("/tokens").request(MediaType.APPLICATION_JSON).post(Entity.json(authentication), Access.class);
	}

}
