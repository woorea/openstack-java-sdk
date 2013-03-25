package org.openstack.swift.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.openstack.swift.SwiftCommand;

public class CreateDirectory implements SwiftCommand<Void> {

	private final String container;
	
	private final String path;
	
	public CreateDirectory(String container, String path) {
		this.container = container;
		this.path = path;
	}

	@Override
	public Void execute(WebTarget endpoint) {
		endpoint.path(container).path(path).request().put(Entity.entity(new byte[1],"application/directory"));
		return null;
	}
	
	

}
