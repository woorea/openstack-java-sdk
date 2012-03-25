package org.openstack.api.identity.resources;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneRole;

public class RoleResource extends Resource {
	
	public RoleResource(Target target) {
		super(target);
	}

	public KeystoneRole get() {
		return target.request().get(KeystoneRole.class);
	}

	public KeystoneRole update(Entity<KeystoneRole> entity) {
		return target.request().put(entity, KeystoneRole.class);
	}

	public Response delete() {
		return target.request().delete();
	}

}
