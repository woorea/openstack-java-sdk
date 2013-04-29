package org.openstack.quantum.api.ports;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Port;
import org.openstack.quantum.model.PortForCreate;

public class CreatePort extends OpenStackRequest {

	private PortForCreate PortForCreate;
	
	public CreatePort(PortForCreate port){
		this.PortForCreate=port;
		method(HttpMethod.POST);
		path("ports");
		header("Accept", "application/json");
		json(PortForCreate);
		returnType(Port.class);
	}
	
}
