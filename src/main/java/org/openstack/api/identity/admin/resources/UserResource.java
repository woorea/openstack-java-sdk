package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.User;
import org.openstack.model.identity.keystone.KeystoneUser;

public class UserResource extends Resource {

	public UserResource(Target target, Properties properties) {
		super(target, properties);
	}

	public KeystoneUser get() {
		return target.request(MediaType.APPLICATION_XML).get(KeystoneUser.class);
	}
	
	public User post(User entity) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(entity), KeystoneUser.class);
	}

	public User put(User entity) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(entity), KeystoneUser.class);
	}
	
	public Response delete() {
		return target.request().delete();
	}

	public User password(User user) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(user), KeystoneUser.class);
		
	}

	public User tenant(User user) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(user), KeystoneUser.class);
		
	}

	public User enabled(User user) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(user), KeystoneUser.class);
		
	}

}
