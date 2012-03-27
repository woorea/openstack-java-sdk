package org.openstack.api.identity.admin.resources;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceList;

public class ServicesResource extends Resource {

	public ServicesResource(Target target) {
		super(target);
	}
	
	public KeystoneServiceList get() {
		return target.request().get(KeystoneServiceList.class);
	}
	
	public KeystoneService post(Entity<KeystoneService> user) {
		return target.request().post(user, KeystoneService.class);
	}
	
	public ServiceResource service(String id) {
		return new ServiceResource(target.path("/{id}").pathParam("id", id));
	}

	
	
}
