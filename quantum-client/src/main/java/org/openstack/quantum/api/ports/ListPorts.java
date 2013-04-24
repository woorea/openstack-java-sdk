package org.openstack.quantum.api.ports;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Ports;

public class ListPorts implements OpenStackCommand<Ports> {
	
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("ports");
		request.header("Accept", "application/json");
		request.returnType(Ports.class);
		return request;
	}

}
