package org.openstack.quantum.api.subnets;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Subnets;

public class ListSubnets extends OpenStackRequest {
	
	public ListSubnets() {
		method(HttpMethod.GET);
		path("subnets");
		header("Accept", "application/json");
		returnType(Subnets.class);
	}

}
