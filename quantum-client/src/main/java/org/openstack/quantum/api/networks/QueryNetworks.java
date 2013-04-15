package org.openstack.quantum.api.networks;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.QuantumCommand;
import org.openstack.quantum.model.Network;
import org.openstack.quantum.model.Networks;

public class QueryNetworks implements QuantumCommand<Networks> {

	public QueryNetworks(Network network) {
		//super(network);
	}

	public OpenStackRequest execute(OpenStackClient client)
	{
//		target = target.path("v2.0").path("networks");
//		target = queryParam(target);
//		return target.request(MediaType.APPLICATION_JSON).get(Networks.class);
		return null;
	}

}
