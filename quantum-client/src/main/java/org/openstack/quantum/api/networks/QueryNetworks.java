package org.openstack.quantum.api.networks;

import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Network;

public class QueryNetworks extends OpenStackRequest {

	public QueryNetworks(Network network) {
		//super(network);
//		target = target.path("v2.0").path("networks");
//		target = queryParam(target);
//		return target.request(MediaType.APPLICATION_JSON).get(Networks.class);
	}

}
