package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.User;
import org.openstack.model.identity.UserForCreate;
import org.openstack.model.identity.UserList;
import org.openstack.model.identity.keystone.KeystoneUser;
import org.openstack.model.identity.keystone.KeystoneUserList;

public class UsersResource extends Resource {

	public UsersResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public UserList get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneUserList.class);
	}
	
	public User post(UserForCreate user) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.json(user), KeystoneUser.class);
	}

	public UserResource user(String id) {
		return new UserResource(target.path("/{id}").pathParam("id", id), properties);
	}

}
