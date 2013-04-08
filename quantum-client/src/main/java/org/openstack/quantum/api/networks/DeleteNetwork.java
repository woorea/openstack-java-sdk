package org.openstack.quantum.api.networks;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.client.QuantumCommand;

public class DeleteNetwork implements QuantumCommand<Void> {
	
	private String id;
	
	public DeleteNetwork(String netId){
		this.id = netId;
	}

	public OpenStackRequest execute(OpenStackClient client) {
		//target.path("v2.0").path("networks").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}
	
}
