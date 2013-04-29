package org.openstack.quantum.api.subnets;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Subnet;
import org.openstack.quantum.model.SubnetForCreate;

public class CreateSubnet extends OpenStackRequest {

	private SubnetForCreate SubnetForCreate;
	
	public CreateSubnet(SubnetForCreate subnet){
		this.SubnetForCreate=subnet;
		method(HttpMethod.POST);
		path("subnets");
		header("Accept", "application/json");
		json(SubnetForCreate);
		returnType(Subnet.class);
	}

	
}
