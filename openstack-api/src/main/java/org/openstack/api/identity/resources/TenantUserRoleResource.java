package org.openstack.api.identity.resources;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneRole;

public class TenantUserRoleResource extends Resource {

	public TenantUserRoleResource(Target target) {
		super(target);
	}
	
	public KeystoneRole put() {
		return target.request(MediaType.APPLICATION_JSON).method("PUT", KeystoneRole.class);
	}
	
	public Response delete() {
		return target.request().delete();
	}

}
