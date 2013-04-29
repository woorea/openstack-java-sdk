package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Endpoint;

public class CreateEndpoint extends OpenStackRequest {

	private Endpoint endpointForCreate;
	
	public CreateEndpoint(Endpoint endpointForCreate) {
		method(HttpMethod.POST);
		path("/endpoints");
		json(endpointForCreate);
		header("Accept", "application/json");
		returnType(Endpoint.class);
	}
	
}
