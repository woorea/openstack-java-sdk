package org.openstack.client.compute;

import org.openstack.client.common.PagingList;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerList;

import com.sun.jersey.api.client.Client;

public class ServersRepresentation extends PagingList<Server, ServerRepresentation> {

	ServersRepresentation(Client client, ServerList model) {
		super(client, model);
	}

	@Override
	protected ServerRepresentation mapToRepresentation(Server model) {
		return new ServerRepresentation(client, model);
	}

}
