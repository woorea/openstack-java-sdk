package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Endpoints;

public class ListEndpoints implements OpenStackCommand<Endpoints>{

	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("/endpoints");
		request.header("Accept", "application/json");
		request.returnType(Endpoints.class);
		return request;
	}

}
