package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Endpoints;

public class ListEndpoints implements KeystoneCommand<Endpoints>{

	@Override
	public Endpoints execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("GET");
		request.path("/endpoints");
		request.header("Accept", "application/json");
		return connector.execute(request, Endpoints.class);
		//return target.path("endpoints").request(MediaType.APPLICATION_JSON).get(Endpoints.class);
	}

}
