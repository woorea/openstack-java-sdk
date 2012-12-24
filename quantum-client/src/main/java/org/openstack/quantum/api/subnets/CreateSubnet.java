package org.openstack.quantum.api.subnets;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.quantum.client.QuantumCommand;
import org.openstack.quantum.model.Subnet;
import org.openstack.quantum.model.SubnetForCreate;

public class CreateSubnet implements QuantumCommand<Subnet> {

	private SubnetForCreate SubnetForCreate;
	
	public CreateSubnet(SubnetForCreate subnet){
		this.SubnetForCreate=subnet;
	}

	public Subnet execute(WebTarget target) {
		return target.path("v2.0").path("subnets").request(MediaType.APPLICATION_JSON).post(Entity.json(SubnetForCreate), Subnet.class);
	}
	
}
