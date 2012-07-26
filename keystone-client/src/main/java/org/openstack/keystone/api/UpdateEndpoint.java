package org.openstack.keystone.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Endpoint;

public class UpdateEndpoint implements KeystoneCommand<Endpoint> {

	private Endpoint endpointForCreate;
	
	public UpdateEndpoint(Endpoint endpointForCreate) {
		this.endpointForCreate = endpointForCreate;
	}

	@Override
	public Endpoint execute(WebTarget target) {
		return target.path("endpoints").request(MediaType.APPLICATION_JSON).put(Entity.json(endpointForCreate), Endpoint.class);
	}
	
}
