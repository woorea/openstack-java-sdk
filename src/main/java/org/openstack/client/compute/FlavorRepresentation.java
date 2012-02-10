package org.openstack.client.compute;

import org.openstack.model.compute.Flavor;

import com.sun.jersey.api.client.Client;

public class FlavorRepresentation {

	private Client client;

	private Flavor model;

	public FlavorRepresentation(Client client, Flavor model) {
		this.client = client;
		this.model = model;
	}

	public Flavor getList() {
		return model;
	}

}
