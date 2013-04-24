package org.openstack.quantum.api.subnets;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Subnets;

public class ListSubnets implements OpenStackCommand<Subnets> {

	public ListSubnets() {
	}
	
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("subnets");
		request.header("Accept", "application/json");
		request.returnType(Subnets.class);
		return request;
	}

}
