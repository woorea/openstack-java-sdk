package org.openstack.quantum.api.networks;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Networks;

public class ListNetworks implements QuantumCommand<Networks> {

	public ListNetworks() {
	}
	
	public Networks execute(OpenStackClientConnector connector, OpenStackRequest request) {
//		return target.path("v2.0").path("networks").request(MediaType.APPLICATION_JSON).get(Networks.class);
		return null;
	}

}
