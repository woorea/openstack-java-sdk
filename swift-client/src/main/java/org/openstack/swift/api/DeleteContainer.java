package org.openstack.swift.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.swift.SwiftCommand;

public class DeleteContainer implements SwiftCommand<Response>{

	private final String containerName;
	
	public DeleteContainer(String containerName) {
		this.containerName = containerName;
	}
	
	@Override
	public Response execute(WebTarget target) {
		return target.path(containerName).request(MediaType.APPLICATION_JSON).delete();
	}

}
