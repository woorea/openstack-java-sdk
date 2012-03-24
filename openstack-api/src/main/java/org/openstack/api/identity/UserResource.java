package org.openstack.api.identity;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneUser;

public class UserResource extends Resource {

	public UserResource(Target target) {
		super(target);
	}

	public KeystoneUser get() {
		return target.request(MediaType.APPLICATION_XML).get(KeystoneUser.class);
	}
	
	public KeystoneUser post(Entity<KeystoneUser> entity) {
		return target.request(MediaType.APPLICATION_JSON).put(entity, KeystoneUser.class);
	}

	public KeystoneUser put(Entity<KeystoneUser> entity) {
		return target.request(MediaType.APPLICATION_JSON).put(entity, KeystoneUser.class);
	}
	
	public Response delete() {
		return target.request().delete();
	}

	public KeystoneUser password(KeystoneUser user) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(user), KeystoneUser.class);
		
	}

	public KeystoneUser tenant(KeystoneUser user) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(user), KeystoneUser.class);
		
	}

	public KeystoneUser enabled(KeystoneUser user) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(user), KeystoneUser.class);
		
	}

}
