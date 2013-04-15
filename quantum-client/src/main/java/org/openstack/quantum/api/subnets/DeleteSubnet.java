package org.openstack.quantum.api.subnets;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.QuantumCommand;

public class DeleteSubnet implements QuantumCommand<Void> {

private String id;
	
	public DeleteSubnet(String SubnetId){
		this.id = SubnetId;
	}

	public OpenStackRequest execute(OpenStackClient client) {
//		target.path("v2.0").path("subnets").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}

}
