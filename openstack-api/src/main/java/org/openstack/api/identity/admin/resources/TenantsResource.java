package org.openstack.api.identity.admin.resources;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneTenant;
import org.openstack.model.identity.KeystoneTenantList;

public class TenantsResource extends Resource {

	public TenantsResource(Target target) {
		super(target);
	}
	
	public KeystoneTenantList get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneTenantList.class);
	}

	public KeystoneTenant post(Entity<KeystoneTenant> tenant) {
		return target.request(MediaType.APPLICATION_JSON).post(tenant, KeystoneTenant.class);
	}
	
	public TenantResource tenant(String id) {
		return new TenantResource(target.path("/{id}").pathParam("id", id));
	}

}
