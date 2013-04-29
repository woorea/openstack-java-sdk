package org.openstack.swift.api;

import org.openstack.base.client.OpenStackRequest;

public class CreateContainer extends OpenStackRequest {
	
	public CreateContainer(String containerName) {
		//return target.path(containerName).request().method("PUT",Entity.text("*"));
	}

}
