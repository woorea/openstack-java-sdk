package org.openstack.api.identity.resources;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

public class TenantUserRolesResource extends Resource {

	public TenantUserRolesResource(Target target) {
		super(target);
	}
	
	public TenantUserRoleResource role(String id) {
		return new TenantUserRoleResource(target.path("/{id}").pathParam("id", id));
	}

}
