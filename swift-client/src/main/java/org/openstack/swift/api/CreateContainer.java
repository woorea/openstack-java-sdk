package org.openstack.swift.api;

import javax.xml.ws.Response;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.swift.SwiftCommand;

public class CreateContainer implements SwiftCommand<Response>{

	private String containerName;
	
	public CreateContainer(String containerName) {
		this.containerName = containerName;
	}
	
	@Override
	public Response execute(OpenStackClientConnector connector, OpenStackRequest request) {
		//return target.path(containerName).request().method("PUT",Entity.text("*"));
		return null;
	}

}
