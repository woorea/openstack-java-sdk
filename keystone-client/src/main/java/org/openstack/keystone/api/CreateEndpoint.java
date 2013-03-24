package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Access;
import org.openstack.keystone.model.Endpoint;

public class CreateEndpoint implements KeystoneCommand<Endpoint> {

	private Endpoint endpointForCreate;
	
	public CreateEndpoint(Endpoint endpointForCreate) {
		this.endpointForCreate = endpointForCreate;
	}

	@Override
	public Endpoint execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("POST");
		request.path("/endpoints");
		request.json(endpointForCreate);
		request.header("Accept", "application/json");
		return connector.execute(request, Endpoint.class);
		//return target.path("endpoints").request(MediaType.APPLICATION_JSON).post(Entity.json(endpointForCreate), Endpoint.class);
	}
	
}
