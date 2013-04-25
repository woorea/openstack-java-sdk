package org.openstack.quantum.api.networks;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Networks;

public class ListNetworks implements OpenStackCommand<Networks> {

	public ListNetworks() {
	}
	
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("networks");
		request.header("Accept", "application/json");
		request.returnType(Networks.class);
		return request;
	}

}
