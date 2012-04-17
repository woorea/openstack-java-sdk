package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

public class TenantUserRolesResource extends Resource {

	public TenantUserRolesResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public TenantUserRoleResource role(String id) {
		return new TenantUserRoleResource(target.path("/{roleId}").pathParam("roleId", id), properties);
	}

}
