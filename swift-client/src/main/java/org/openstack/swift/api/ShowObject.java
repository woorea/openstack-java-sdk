package org.openstack.swift.api;

import javax.xml.ws.Response;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.swift.SwiftCommand;

public class ShowObject implements SwiftCommand<Response> {

	private String containerName;
	
	private String objectName;
	
	public ShowObject(String containerName, String objectName) {
		this.containerName = containerName;
		this.objectName = objectName;
	}
	
	@Override
	public OpenStackRequest execute(OpenStackClient client) {
//		return target.path(containerName).path(objectName).request(MediaType.APPLICATION_JSON).head();
		return null;
	}

}
