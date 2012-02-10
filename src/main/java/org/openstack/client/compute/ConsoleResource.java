package org.openstack.client.compute;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Console;

import com.sun.jersey.api.client.Client;

public class ConsoleResource extends Resource {
	
	public ConsoleResource(Client client, String resource) {
		super(client, resource);
	}

	public Console show() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(Console.class);
	}
	
	public void delete() {
		client.resource(resource).accept(MediaType.APPLICATION_XML).post(String.class);
	}
	
}

