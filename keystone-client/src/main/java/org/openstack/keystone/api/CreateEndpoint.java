package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Endpoint;

public class CreateEndpoint implements OpenStackCommand<Endpoint> {

	private Endpoint endpointForCreate;
	
	public CreateEndpoint(Endpoint endpointForCreate) {
		this.endpointForCreate = endpointForCreate;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.POST);
		request.path("/endpoints");
		request.json(endpointForCreate);
		request.header("Accept", "application/json");
		request.returnType(Endpoint.class);
		return request;
	}
	
}
