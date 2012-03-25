package org.openstack.api.identity.resources;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

public class TenantUserResource extends Resource {

	protected TenantUserResource(Target target) {
		super(target);
	}
	
	public TenantUserRolesResource roles() {
		return path("/roles/OS-KSADM", TenantUserRolesResource.class);
	}

}
