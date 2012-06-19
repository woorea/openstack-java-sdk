package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.keystone.KeystoneTenant;

public class TenantResource extends Resource {

	public TenantResource(Target target, Properties properties) {
		super(target, properties);
	}

	public KeystoneTenant get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneTenant.class);
	}

	public Tenant update(Entity<Tenant> entity) {
		return target.request(MediaType.APPLICATION_JSON).put(entity, KeystoneTenant.class);
	}

	public Tenant put(Tenant entity) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(entity), KeystoneTenant.class);
	}

	public Response delete() {
		return target.request(MediaType.APPLICATION_JSON).delete();
	}
	
	public TenantUsersResource users() {
		return path("users", TenantUsersResource.class);
	}

}
