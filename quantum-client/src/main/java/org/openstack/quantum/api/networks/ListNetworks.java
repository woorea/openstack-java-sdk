package org.openstack.quantum.api.networks;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Networks;

public class ListNetworks implements OpenStackCommand<Networks> {

	public ListNetworks() {
	}
	
	public OpenStackRequest execute(OpenStackClient client) {
//		return target.path("v2.0").path("networks").request(MediaType.APPLICATION_JSON).get(Networks.class);
		return null;
	}

}
