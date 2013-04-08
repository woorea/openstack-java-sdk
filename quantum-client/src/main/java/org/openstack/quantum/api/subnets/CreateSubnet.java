package org.openstack.quantum.api.subnets;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Subnet;
import org.openstack.quantum.model.SubnetForCreate;

public class CreateSubnet implements QuantumCommand<Subnet> {

	private SubnetForCreate SubnetForCreate;
	
	public CreateSubnet(SubnetForCreate subnet){
		this.SubnetForCreate=subnet;
	}

	public OpenStackRequest execute(OpenStackClient client) {
//		return target.path("v2.0").path("subnets").request(MediaType.APPLICATION_JSON).post(Entity.json(SubnetForCreate), Subnet.class);
		return null;
	}
	
}
