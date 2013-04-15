package org.openstack.quantum.api.ports;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.QuantumCommand;
import org.openstack.quantum.model.Port;
import org.openstack.quantum.model.PortForCreate;

public class CreatePort implements QuantumCommand<Port> {

	private PortForCreate PortForCreate;
	
	public CreatePort(PortForCreate port){
		this.PortForCreate=port;
	}

	public OpenStackRequest execute(OpenStackClient client) {
//		return target.path("v2.0").path("ports").request(MediaType.APPLICATION_JSON).post(Entity.json(PortForCreate), Port.class);
		return null;
	}
	

}
