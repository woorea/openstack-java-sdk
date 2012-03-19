package org.openstack.api.identity;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeyStoneRole;

public class RoleResource extends Resource {
	
	public RoleResource() {
	}
	
	public RoleResource(Target target) {
		super(target);
	}

	public KeyStoneRole get() {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", "secret0").get(KeyStoneRole.class);
	}

	public KeyStoneRole update(Entity<KeyStoneRole> entity) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", "secret0").put(entity, KeyStoneRole.class);
	}

	public void delete() {
		target.request().header("X-Auth-Token", "secret0").delete();
	}

}
