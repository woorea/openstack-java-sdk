package org.openstack.client.identity;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.EndpointTemplate;

import com.sun.jersey.api.client.Client;

public class EndpointTemplateResource extends Resource {

	public EndpointTemplateResource(Client client, String resource) {
		super(client, resource);
	}

	public EndpointTemplate show() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(EndpointTemplate.class);
	}

	public EndpointTemplate update() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).put(EndpointTemplate.class);
	}

	public void delete() {
		client.resource(resource).accept(MediaType.APPLICATION_XML).delete();
	}

}
