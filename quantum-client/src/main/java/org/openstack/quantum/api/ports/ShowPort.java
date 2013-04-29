package org.openstack.quantum.api.ports;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Port;

public class ShowPort extends OpenStackRequest {

private String id;
	
	public ShowPort(String id) {
		this.id = id;
	}
	
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("ports/").path(id);
		request.header("Accept", "application/json");
		request.returnType(Port.class);
		return request;
	}

}
