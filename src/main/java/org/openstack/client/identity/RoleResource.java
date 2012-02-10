package org.openstack.client.identity;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.Role;

import com.sun.jersey.api.client.Client;

public class RoleResource extends Resource {

	public RoleResource(Client client, String resource) {
		super(client, resource);
	}

	public Role show() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(Role.class);
	}

	public Role update() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).put(Role.class);
	}

	public void delete() {
		client.resource(resource).accept(MediaType.APPLICATION_XML).delete();
	}

}
