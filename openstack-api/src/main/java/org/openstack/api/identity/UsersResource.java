package org.openstack.api.identity;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneUser;
import org.openstack.model.identity.KeyStoneUserList;

public class UsersResource extends Resource {

	public UsersResource(Target target) {
		super(target);
	}
	
	public KeyStoneUserList get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(KeyStoneUserList.class);
	}
	
	public KeyStoneUser post(Entity<KeyStoneUser> user) {
		return target.request(MediaType.APPLICATION_JSON).post(user, KeyStoneUser.class);
	}

	public UserResource user(String id) {
		return new UserResource(target.path("/{id}").pathParam("id", id));
	}
	
	

}
