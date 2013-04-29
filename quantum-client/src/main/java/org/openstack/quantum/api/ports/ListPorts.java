package org.openstack.quantum.api.ports;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.quantum.model.Ports;

public class ListPorts extends OpenStackRequest {
	
	public ListPorts() {
		method(HttpMethod.GET);
		path("ports");
		header("Accept", "application/json");
		returnType(Ports.class);
	}

}
