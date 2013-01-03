package org.openstack.quantum.api.networks;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Network;

public class ShowNetwork implements QuantumCommand<Network> {
	
	private String id;
	
	public ShowNetwork(String id) {
		this.id = id;
	}
	
	public Network execute(WebTarget target) {
		return target.path("v2.0").path("networks").path(id).request(MediaType.APPLICATION_JSON).get(Network.class);
	}

}
