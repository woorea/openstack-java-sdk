package org.openstack.quantum.api.ports;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Port;

public class ShowPort implements QuantumCommand<Port> {

private String id;
	
	public ShowPort(String id) {
		this.id = id;
	}
	
	public Port execute(OpenStackClientConnector connector, OpenStackRequest request) {
//		return target.path("v2.0").path("ports").path(id).request(MediaType.APPLICATION_JSON).get(Port.class);
		return null;
	}

}
