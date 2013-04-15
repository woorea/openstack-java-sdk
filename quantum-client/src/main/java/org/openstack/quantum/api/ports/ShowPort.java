package org.openstack.quantum.api.ports;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Port;

public class ShowPort implements OpenStackCommand<Port> {

private String id;
	
	public ShowPort(String id) {
		this.id = id;
	}
	
	public OpenStackRequest execute(OpenStackClient client) {
//		return target.path("v2.0").path("ports").path(id).request(MediaType.APPLICATION_JSON).get(Port.class);
		return null;
	}

}
