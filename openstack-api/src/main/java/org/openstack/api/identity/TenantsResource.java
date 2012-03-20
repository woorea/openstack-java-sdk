package org.openstack.api.identity;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneTenantList;

public class TenantsResource extends Resource {

	public TenantsResource(Target target) {
		super(target);
	}
	
	public KeyStoneTenantList get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(KeyStoneTenantList.class);
	}

	public KeyStoneTenant post(Entity<KeyStoneTenant> tenant) {
		return target.request(MediaType.APPLICATION_JSON).post(tenant, KeyStoneTenant.class);
	}
	
	public TenantResource tenant(String id) {
		return new TenantResource(target.path("/{id}").pathParam("id", id));
	}

}
