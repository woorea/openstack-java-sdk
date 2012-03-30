package org.openstack.api.identity.admin.resources;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.keystone.KeystoneTenant;
import org.openstack.model.identity.keystone.KeystoneTenantList;

public class TenantsResource extends Resource {

	public TenantsResource(Target target) {
		super(target);
	}
	
	public TenantList get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneTenantList.class);
	}

	public Tenant post(Tenant tenant) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.json(tenant), KeystoneTenant.class);
	}
	
	public TenantResource tenant(String id) {
		return new TenantResource(target.path("/{tenantId}").pathParam("tenantId", id));
	}

}
