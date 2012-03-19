package org.openstack.api.identity;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneTenantList;

public class TenantsResource extends Resource {
	
	public TenantsResource() {
		
	}
	
	public TenantsResource(Target target) {
		super(target);
	}
	
	public KeyStoneTenantList get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).get(KeyStoneTenantList.class);
	}

	public KeyStoneTenant post(Entity<KeyStoneTenant> tenant) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", "secret0").post(tenant, KeyStoneTenant.class);
	}
	
	public TenantResource tenant(String id) {
		return new TenantResource(target.path("/{id}").pathParam("id", id));
	}

}
