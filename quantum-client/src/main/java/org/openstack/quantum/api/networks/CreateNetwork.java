package org.openstack.quantum.api.networks;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Network;
import org.openstack.quantum.model.NetworkForCreate;

public class CreateNetwork extends OpenStackRequest {
	
	private NetworkForCreate networkForCreate;
	
	public CreateNetwork(NetworkForCreate net){
		this.networkForCreate=net;
		
		method(HttpMethod.POST);
		path("networks");
		header("Accept", "application/json");
		json(networkForCreate);
		returnType(Network.class);
	}
	
}
