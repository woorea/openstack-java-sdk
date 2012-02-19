package org.openstack.client.compute;

import org.openstack.model.compute.Flavor;

import com.sun.jersey.api.client.Client;

public class FlavorRepresentation extends RepresentationBase<Flavor> {

	public FlavorRepresentation(Client client, Flavor model) {
		super(client, model);
	}

}
