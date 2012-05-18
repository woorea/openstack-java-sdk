package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceList;
import org.openstack.model.identity.keystone.KeystoneService;
import org.openstack.model.identity.keystone.KeystoneServiceList;

public class ServicesResource extends Resource {

	public ServicesResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public ServiceList get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneServiceList.class);
	}
	
	public Service post(Service service) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.json(service), KeystoneService.class);
	}
	
	public ServiceResource service(String id) {
		return new ServiceResource(target.path("/{id}").pathParam("id", id), properties);
	}

	
	
}
