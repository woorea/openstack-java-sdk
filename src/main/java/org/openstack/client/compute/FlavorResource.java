package org.openstack.client.compute;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

public class FlavorResource extends Resource {
	
	
	
	public FlavorResource(Client client, String resource) {
		super(client, resource);
	}

	public FlavorResource show() {
		return this;
	}
	
}

