package org.openstack.keystone.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Service;

public class CreateService implements KeystoneCommand<Service> {

	private Service serviceForCreate;
	
	public CreateService(Service serviceForCreate) {
		this.serviceForCreate = serviceForCreate;
	}

	@Override
	public Service execute(WebTarget target) {
		return target.path("OS-KSADM/services").request(MediaType.APPLICATION_JSON).post(Entity.json(serviceForCreate), Service.class);
	}
	
}
