package org.openstack.api.identity;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneTenant;

public class TenantResource extends Resource {

	public TenantResource(Target target) {
		super(target);
	}

	public KeystoneTenant get() {
		return target.request(MediaType.APPLICATION_XML).get(KeystoneTenant.class);
	}

	public KeystoneTenant update(Entity<KeystoneTenant> entity) {
		return target.request(MediaType.APPLICATION_JSON).put(entity, KeystoneTenant.class);
	}

	public Response delete() {
		return target.request().delete();
	}
	
	public TenantUsersResource users() {
		return path("users", TenantUsersResource.class);
	}

}
