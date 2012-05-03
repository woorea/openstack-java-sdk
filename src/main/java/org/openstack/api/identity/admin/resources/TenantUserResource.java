package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

public class TenantUserResource extends Resource {

	protected TenantUserResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public TenantUserRolesResource roles() {
		//return path("/roles/OS-KSADM", TenantUserRolesResource.class);
		return path("/roles", TenantUserRolesResource.class);
	}

}
