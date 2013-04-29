package org.openstack.quantum.api.ports;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Port;
import org.openstack.quantum.model.PortForCreate;

public class CreatePort implements OpenStackCommand<Port> {

	private PortForCreate PortForCreate;
	
	public CreatePort(PortForCreate port){
		this.PortForCreate=port;
	}

	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.POST);
		request.path("ports");
		request.header("Accept", "application/json");
		request.json(PortForCreate);
		request.returnType(Port.class);
		return request;
	}
	
}
