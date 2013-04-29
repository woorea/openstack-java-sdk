package org.openstack.swift.api;

import org.openstack.base.client.OpenStackRequest;

public class DeleteContainer extends OpenStackRequest {

	private String containerName;
	
	public DeleteContainer(String containerName) {
		this.containerName = containerName;
		//return target.path(containerName).request(MediaType.APPLICATION_JSON).delete();
	}

}
