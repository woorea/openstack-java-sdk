package org.openstack.api.identity.admin.resources;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.RoleList;
import org.openstack.model.identity.keystone.KeystoneRole;
import org.openstack.model.identity.keystone.KeystoneRoleList;

public class RolesResource extends Resource {
	
	public RolesResource(Target target) {
		super(target);
	}
	
	public RoleList get() {
		return target.request().get(KeystoneRoleList.class);
	}
	
	public Role post(Role role) {
		return target.request().post(Entity.json(role), KeystoneRole.class);
	}
	
	public RoleResource role(String id) {
		return new RoleResource(target.path("/{id}").pathParam("id", id));
	}
	
}
