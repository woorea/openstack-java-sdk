package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.keystone.KeystoneRole;

public class TenantUserRoleResource extends Resource {

	public TenantUserRoleResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public Role put() {
		return target.request(MediaType.APPLICATION_JSON).method("PUT", KeystoneRole.class);
	}
	
	public Response delete() {
		return target.request().delete();
	}

}
