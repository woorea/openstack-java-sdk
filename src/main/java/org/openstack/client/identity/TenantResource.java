package org.openstack.client.identity;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.Tenant;

import com.sun.jersey.api.client.Client;

public class TenantResource extends Resource {

	public TenantResource(Client client, String resource) {
		super(client, resource);
	}

	public Tenant show() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(Tenant.class);
	}

	public Tenant update() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).put(Tenant.class);
	}

	public void delete() {
		client.resource(resource).accept(MediaType.APPLICATION_XML).delete();
	}

}
