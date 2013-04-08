package org.openstack.quantum.api.ports;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Ports;

public class ListPorts implements QuantumCommand<Ports> {
	
	public OpenStackRequest execute(OpenStackClient client) {
//		return target.path("v2.0").path("ports").request(MediaType.APPLICATION_JSON).get(Ports.class);
		return null;
	}

}
