package org.openstack.quantum.api.ports;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class DeletePort implements OpenStackCommand<Void> {

private String id;
	
	public DeletePort(String portId){
		this.id = portId;
	}

	public OpenStackRequest execute(OpenStackClient client) {
//		target.path("v2.0").path("ports").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}
}
