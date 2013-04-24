package org.openstack.quantum.api.networks;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class DeleteNetwork implements OpenStackCommand<Void> {
	
	private String id;
	
	public DeleteNetwork(String netId){
		this.id = netId;
	}

	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.DELETE);
		request.path("networks/").path(id);
		request.header("Accept", "application/json");
		return request;
	}
	
}
