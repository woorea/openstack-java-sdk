package org.openstack.quantum.api.networks;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Network;

public class ShowNetwork implements OpenStackCommand<Network> {
	
	private String id;
	
	public ShowNetwork(String id) {
		this.id = id;
	}
	
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("networks/").path(id);
		request.header("Accept", "application/json");
		request.returnType(Network.class);
		return request;
	}

}
