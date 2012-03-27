package org.openstack.api.identity.admin.resources;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneUser;
import org.openstack.model.identity.KeystoneUserList;

public class UsersResource extends Resource {

	public UsersResource(Target target) {
		super(target);
	}
	
	public KeystoneUserList get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneUserList.class);
	}
	
	public KeystoneUser post(Entity<KeystoneUser> user) {
		return target.request(MediaType.APPLICATION_JSON).post(user, KeystoneUser.class);
	}

	public UserResource user(String id) {
		return new UserResource(target.path("/{id}").pathParam("id", id));
	}

}
