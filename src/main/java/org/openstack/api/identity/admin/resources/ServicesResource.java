package org.openstack.api.identity.admin.resources;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceList;
import org.openstack.model.identity.keystone.KeystoneService;
import org.openstack.model.identity.keystone.KeystoneServiceList;

public class ServicesResource extends Resource {

	public ServicesResource(Target target) {
		super(target);
	}
	
	public ServiceList get() {
		return target.request().get(KeystoneServiceList.class);
	}
	
	public Service post(Service service) {
		return target.request().post(Entity.json(service), KeystoneService.class);
	}
	
	public ServiceResource service(String id) {
		return new ServiceResource(target.path("/{id}").pathParam("id", id));
	}

	
	
}
