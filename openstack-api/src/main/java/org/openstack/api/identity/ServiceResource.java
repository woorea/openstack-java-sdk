package org.openstack.api.identity;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeyStoneService;
import org.openstack.model.identity.KeyStoneService;

public class ServiceResource extends Resource {
	
	public ServiceResource() {
	}
	
	public ServiceResource(Target target) {
		super(target);
	}


	public KeyStoneService get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeyStoneService.class);
	}

	public KeyStoneService update(Entity<KeyStoneService> entity) {
		return target.request(MediaType.APPLICATION_JSON).put(entity, KeyStoneService.class);
	}
	
	public void delete() {
		target.request().delete();
	}

}
