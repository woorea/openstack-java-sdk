package org.openstack.swift.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.swift.SwiftCommand;

public class CreateDirectory implements SwiftCommand<Void> {

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
