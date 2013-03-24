package org.openstack.swift.api;

import javax.xml.ws.Response;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.swift.SwiftCommand;

public class ShowContainer implements SwiftCommand<Response>{

	private String containerName;
	
	public ShowContainer(String containerName) {
		this.containerName = containerName;
	}
	
	@Override
	public Response execute(OpenStackClientConnector connector, OpenStackRequest request) {
//		return target.path(containerName).request(MediaType.APPLICATION_JSON).head();
		return null;
	}

}
