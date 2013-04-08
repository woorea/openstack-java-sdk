package org.openstack.quantum.api.subnets;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Subnets;

public class ListSubnets implements QuantumCommand<Subnets> {

	public ListSubnets() {
	}
	
	public OpenStackRequest execute(OpenStackClient client) {
//		return target.path("v2.0").path("subnets").request(MediaType.APPLICATION_JSON).get(Subnets.class);
		return null;
	}

}
