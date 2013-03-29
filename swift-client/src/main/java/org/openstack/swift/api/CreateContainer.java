package org.openstack.swift.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.openstack.swift.SwiftCommand;

public class CreateContainer implements SwiftCommand<Response>{

	private final String containerName;
	
	public CreateContainer(String containerName) {
		this.containerName = containerName;
	}
	
	@Override
	public Response execute(WebTarget target) {
		return target.path(containerName).request().method("PUT",Entity.text("*"));
	}

}
