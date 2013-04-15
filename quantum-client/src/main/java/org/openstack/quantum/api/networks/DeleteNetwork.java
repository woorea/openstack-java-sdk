package org.openstack.quantum.api.networks;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class DeleteNetwork implements OpenStackCommand<Void> {
	
	private String id;
	
	public DeleteNetwork(String netId){
		this.id = netId;
	}

	public OpenStackRequest execute(OpenStackClient client) {
		//target.path("v2.0").path("networks").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}
	
}
