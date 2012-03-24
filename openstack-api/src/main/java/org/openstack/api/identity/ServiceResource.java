package org.openstack.api.identity;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneService;

public class ServiceResource extends Resource {

	public ServiceResource(Target target) {
		super(target);
	}


	public KeystoneService get() {
		return target.request().get(KeystoneService.class);
	}

	public KeystoneService update(Entity<KeystoneService> entity) {
		return target.request().put(entity, KeystoneService.class);
	}
	
	public Response delete() {
		return target.request().delete();
	}

}
