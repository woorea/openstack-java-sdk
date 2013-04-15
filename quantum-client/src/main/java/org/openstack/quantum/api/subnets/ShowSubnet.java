package org.openstack.quantum.api.subnets;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Subnet;

public class ShowSubnet implements OpenStackCommand<Subnet> {

private String id;
	
	public ShowSubnet(String id) {
		this.id = id;
	}
	
	public OpenStackRequest execute(OpenStackClient client) {
//		return target.path("v2.0").path("subnets").path(id).request(MediaType.APPLICATION_JSON).get(Subnet.class);
		return null;
	}	
}
