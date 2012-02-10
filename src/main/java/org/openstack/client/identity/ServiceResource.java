package org.openstack.client.identity;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.Service;

import com.sun.jersey.api.client.Client;

public class ServiceResource extends Resource {

	public ServiceResource(Client client, String resource) {
		super(client, resource);
	}

	public Service show() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(Service.class);
	}

	public Service update() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).put(Service.class);
	}

	public void delete() {
		client.resource(resource).accept(MediaType.APPLICATION_XML).delete();
	}

}
