package org.openstack.swift.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.swift.SwiftCommand;

public class DeleteObject implements SwiftCommand<Response>{

	private String containerName;
	
	private String objectName;
	
	public DeleteObject(String containerName, String objectName) {
		this.containerName = containerName;
		this.objectName = objectName;
	}
	
	@Override
	public Response execute(WebTarget target) {
		return target.path(containerName).path(objectName).request(MediaType.APPLICATION_JSON).delete();
	}

}
