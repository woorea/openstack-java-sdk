package org.openstack.quantum.api.networks;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Network;

public class ShowNetwork extends OpenStackRequest {
	
	private String id;
	
	public ShowNetwork(String id) {
		this.id = id;
		method(HttpMethod.GET);
		path("networks/").path(id);
		header("Accept", "application/json");
		returnType(Network.class);
	}

}
