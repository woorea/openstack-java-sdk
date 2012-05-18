package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.keystone.KeystoneService;

public class ServiceResource extends Resource {

	public ServiceResource(Target target, Properties properties) {
		super(target, properties);
	}


	public KeystoneService get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneService.class);
	}

	public Service update(Entity<Service> entity) {
		return target.request(MediaType.APPLICATION_JSON).put(entity, KeystoneService.class);
	}
	
	public Response delete() {
		return target.request(MediaType.APPLICATION_JSON).delete();
	}

}
