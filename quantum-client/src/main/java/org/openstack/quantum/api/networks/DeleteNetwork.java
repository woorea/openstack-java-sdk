package org.openstack.quantum.api.networks;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;

public class DeleteNetwork extends OpenStackRequest {
	
	private String id;
	
	public DeleteNetwork(String netId){
		this.id = netId;
		method(HttpMethod.DELETE);
		path("networks/").path(id);
		header("Accept", "application/json");
	}
	
}
