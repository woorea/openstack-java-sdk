package org.openstack.api.identity.resources;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneTenantList;

public class TenantsResource extends Resource {

	public TenantsResource(Target target) {
		super(target);
	}
	
	public KeystoneTenantList get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneTenantList.class);
	}

}
