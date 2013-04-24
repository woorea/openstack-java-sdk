package org.openstack.quantum.api.ports;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class DeletePort implements OpenStackCommand<Void> {

private String id;
	
	public DeletePort(String portId){
		this.id = portId;
	}

	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.DELETE);
		request.path("ports/").path(id);
		request.header("Accept", "application/json");
		return request;
	}
}
