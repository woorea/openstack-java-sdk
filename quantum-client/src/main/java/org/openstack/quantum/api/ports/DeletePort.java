package org.openstack.quantum.api.ports;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;

public class DeletePort extends OpenStackRequest {

private String id;
	
	public DeletePort(String portId){
		this.id = portId;
		method(HttpMethod.DELETE);
		path("ports/").path(id);
		header("Accept", "application/json");
	}

}
