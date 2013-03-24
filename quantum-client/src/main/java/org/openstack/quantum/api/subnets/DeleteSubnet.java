package org.openstack.quantum.api.subnets;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.client.QuantumCommand;

public class DeleteSubnet implements QuantumCommand<Void> {

private String id;
	
	public DeleteSubnet(String SubnetId){
		this.id = SubnetId;
	}

	public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
//		target.path("v2.0").path("subnets").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}

}
