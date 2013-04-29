package org.openstack.quantum.api.subnets;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Subnet;

public class ShowSubnet extends OpenStackRequest {
	
	public ShowSubnet(String id) {
		method(HttpMethod.GET);
		path("subnets").path(id);
		header("Accept", "application/json");
		returnType(Subnet.class);
	}

}
