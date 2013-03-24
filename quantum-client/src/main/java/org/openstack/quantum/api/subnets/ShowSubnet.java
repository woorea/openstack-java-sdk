package org.openstack.quantum.api.subnets;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Subnet;

public class ShowSubnet implements QuantumCommand<Subnet> {

private String id;
	
	public ShowSubnet(String id) {
		this.id = id;
	}
	
	public Subnet execute(OpenStackClientConnector connector, OpenStackRequest request) {
//		return target.path("v2.0").path("subnets").path(id).request(MediaType.APPLICATION_JSON).get(Subnet.class);
		return null;
	}	
}
