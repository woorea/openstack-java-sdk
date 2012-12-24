package org.openstack.quantum.api.ports;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Port;
import org.openstack.quantum.model.PortForCreate;

public class CreatePort implements QuantumCommand<Port> {

	private PortForCreate PortForCreate;
	
	public CreatePort(PortForCreate port){
		this.PortForCreate=port;
	}

	public Port execute(WebTarget target) {
		return target.path("v2.0").path("ports").request(MediaType.APPLICATION_JSON).post(Entity.json(PortForCreate), Port.class);
	}
	

}
