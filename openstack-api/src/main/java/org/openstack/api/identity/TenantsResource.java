package org.openstack.api.identity;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneTenant;
import org.openstack.model.identity.KeystoneTenantList;

public class TenantsResource extends Resource {

	public TenantsResource(Target target) {
		super(target);
	}
	
	public KeystoneTenantList get() {
		return target.request().get(KeystoneTenantList.class);
	}

	public KeystoneTenant post(Entity<KeystoneTenant> tenant) {
		return target.request().post(tenant, KeystoneTenant.class);
	}
	
	public TenantResource tenant(String id) {
		return new TenantResource(target.path("/{id}").pathParam("id", id));
	}

}
