package org.openstack.quantum.api.networks;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.QuantumCommand;
import org.openstack.quantum.model.Network;
import org.openstack.quantum.model.NetworkForCreate;

public class CreateNetwork implements QuantumCommand<Network> {
	
	private NetworkForCreate networkForCreate;
	
	public CreateNetwork(NetworkForCreate net){
		this.networkForCreate=net;
	}

	public OpenStackRequest execute(OpenStackClient client) {
//		return target.path("v2.0").path("networks").request(MediaType.APPLICATION_JSON).post(Entity.json(networkForCreate), Network.class)
		return null;
	}
	
	
}
