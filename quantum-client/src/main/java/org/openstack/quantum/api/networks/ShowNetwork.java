package org.openstack.quantum.api.networks;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.QuantumCommand;
import org.openstack.quantum.model.Network;

public class ShowNetwork implements QuantumCommand<Network> {
	
	private String id;
	
	public ShowNetwork(String id) {
		this.id = id;
	}
	
	public OpenStackRequest execute(OpenStackClient client) {
//		return target.path("v2.0").path("networks").path(id).request(MediaType.APPLICATION_JSON).get(Network.class);
		return null;
	}

}
