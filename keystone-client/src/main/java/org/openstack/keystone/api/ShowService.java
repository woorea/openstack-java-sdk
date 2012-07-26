package org.openstack.keystone.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Service;

public class ShowService implements KeystoneCommand<Service>{
	
	private String id;
	
	public ShowService(String id) {
		this.id = id;
	}

	@Override
	public Service execute(WebTarget target) {
		return target.path("OS-KSADM/services").path(id).request(MediaType.APPLICATION_JSON).get(Service.class);
	}

}
