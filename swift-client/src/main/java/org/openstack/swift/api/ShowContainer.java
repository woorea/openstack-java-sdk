package org.openstack.swift.api;

import javax.xml.ws.Response;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class ShowContainer implements OpenStackCommand<Response>{

	private String containerName;
	
	public ShowContainer(String containerName) {
		this.containerName = containerName;
	}
	
	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
//		return target.path(containerName).request(MediaType.APPLICATION_JSON).head();
		return null;
	}

}
