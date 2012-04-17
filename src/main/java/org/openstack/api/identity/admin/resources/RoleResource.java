package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.keystone.KeystoneRole;

public class RoleResource extends Resource {
	
	public RoleResource(Target target, Properties properties) {
		super(target, properties);
	}

	public KeystoneRole get() {
		return target.request().get(KeystoneRole.class);
	}

	public Role update(Entity<Role> entity) {
		return target.request().put(entity, KeystoneRole.class);
	}

	public Response delete() {
		return target.request().delete();
	}

}
