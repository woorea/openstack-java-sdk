package org.openstack.swift.api;

import javax.xml.ws.Response;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class CreateContainer implements OpenStackCommand<Response>{

	private String containerName;
	
	public CreateContainer(String containerName) {
		this.containerName = containerName;
	}
	
	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
		//return target.path(containerName).request().method("PUT",Entity.text("*"));
		return null;
	}

}
