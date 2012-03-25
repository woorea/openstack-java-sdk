package org.openstack.api.identity.resources;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneRole;
import org.openstack.model.identity.KeystoneRoleList;

public class RolesResource extends Resource {
	
	public RolesResource(Target target) {
		super(target);
	}
	
	public KeystoneRoleList get() {
		return target.request().get(KeystoneRoleList.class);
	}
	
	public KeystoneRole post(Entity<KeystoneRole> user) {
		return target.request().post(user, KeystoneRole.class);
	}
	
	public RoleResource role(String id) {
		return new RoleResource(target.path("/{id}").pathParam("id", id));
	}
	
}
