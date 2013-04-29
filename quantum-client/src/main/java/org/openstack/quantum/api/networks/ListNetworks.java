package org.openstack.quantum.api.networks;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Networks;

public class ListNetworks extends OpenStackRequest {

	public ListNetworks() {
		method(HttpMethod.GET);
		path("networks");
		header("Accept", "application/json");
		returnType(Networks.class);
	}

}
