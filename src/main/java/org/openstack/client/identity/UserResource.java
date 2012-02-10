package org.openstack.client.identity;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.User;

import com.sun.jersey.api.client.Client;

public class UserResource extends Resource {

	public UserResource(Client client, String resource) {
		super(client, resource);
	}

	public User show() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(User.class);
	}

	public User update() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).put(User.class);
	}

	public void delete() {
		client.resource(resource).accept(MediaType.APPLICATION_XML).delete();
	}

}
