package org.openstack.swift.api;

import javax.xml.ws.Response;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.swift.SwiftCommand;

public class DeleteContainer implements SwiftCommand<Response>{

	private String containerName;
	
	public DeleteContainer(String containerName) {
		this.containerName = containerName;
	}
	
	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		//return target.path(containerName).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}

}
