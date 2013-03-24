package org.openstack.quantum.api.networks;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Network;
import org.openstack.quantum.model.NetworkForCreate;

public class CreateNetwork implements QuantumCommand<Network> {
	
	private NetworkForCreate networkForCreate;
	
	public CreateNetwork(NetworkForCreate net){
		this.networkForCreate=net;
	}

	public Network execute(OpenStackClientConnector connector, OpenStackRequest request) {
//		return target.path("v2.0").path("networks").request(MediaType.APPLICATION_JSON).post(Entity.json(networkForCreate), Network.class)
		return null;
	}
	
	
}
