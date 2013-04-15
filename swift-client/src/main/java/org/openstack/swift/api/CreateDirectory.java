package org.openstack.swift.api;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class CreateDirectory implements OpenStackCommand<Void> {

	private String container;
	
	private String path;
	
	public CreateDirectory(String container, String path) {
		this.container = container;
		this.path = path;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
//		endpoint.path(container).path(path).request().put(Entity.entity(new byte[1],"application/directory"));
		return null;
	}
	
	

}
