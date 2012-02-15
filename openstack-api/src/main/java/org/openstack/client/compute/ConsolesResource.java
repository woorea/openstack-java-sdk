package org.openstack.client.compute;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.ConsoleList;

import com.sun.jersey.api.client.Client;

public class ConsolesResource extends Resource {

	public ConsolesResource(Client client, String resource) {
		super(client, resource);
	}
	
	public ConsoleList list() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(ConsoleList.class);
	}
	
	public String create() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).post(String.class);
	}
	
	public ConsoleResource console(String id) {
		return new ConsoleResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}

}
