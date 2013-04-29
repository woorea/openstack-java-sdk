package org.openstack.swift.api;

import javax.xml.ws.Response;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class ShowObject implements OpenStackCommand<Response> {

	private String containerName;
	
	private String objectName;
	
	public ShowObject(String containerName, String objectName) {
		this.containerName = containerName;
		this.objectName = objectName;
	}
	
	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
//		return target.path(containerName).path(objectName).request(MediaType.APPLICATION_JSON).head();
		return null;
	}

}
