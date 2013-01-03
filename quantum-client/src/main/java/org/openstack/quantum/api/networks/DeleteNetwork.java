package org.openstack.quantum.api.networks;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.quantum.client.QuantumCommand;

public class DeleteNetwork implements QuantumCommand<Void> {
	
	private String id;
	
	public DeleteNetwork(String netId){
		this.id = netId;
	}

	public Void execute(WebTarget target) {
		target.path("v2.0").path("networks").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}
	
}
