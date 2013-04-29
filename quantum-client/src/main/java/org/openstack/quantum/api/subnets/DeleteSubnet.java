package org.openstack.quantum.api.subnets;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;

public class DeleteSubnet extends OpenStackRequest {
	
	public DeleteSubnet(String id){
		method(HttpMethod.DELETE);
		path("subnets").path(id);
		header("Accept", "application/json");
	}

}
