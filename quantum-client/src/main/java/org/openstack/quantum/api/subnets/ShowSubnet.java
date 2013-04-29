package org.openstack.quantum.api.subnets;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Subnet;

public class ShowSubnet implements OpenStackCommand<Subnet> {

private String id;
	
	public ShowSubnet(String id) {
		this.id = id;
	}
	
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("subnets").path(id);
		request.header("Accept", "application/json");
		request.returnType(Subnet.class);
		return request;
	}

}
