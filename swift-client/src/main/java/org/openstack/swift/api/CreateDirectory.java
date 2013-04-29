package org.openstack.swift.api;

import org.openstack.base.client.OpenStackRequest;

public class CreateDirectory extends OpenStackRequest {

	private String container;
	
	private String path;
	
	public CreateDirectory(String container, String path) {
		this.container = container;
		this.path = path;
//		endpoint.path(container).path(path).request().put(Entity.entity(new byte[1],"application/directory"));
	}
	
}
