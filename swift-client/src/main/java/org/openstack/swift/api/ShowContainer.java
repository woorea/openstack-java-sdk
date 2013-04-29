package org.openstack.swift.api;

import org.openstack.base.client.OpenStackRequest;

public class ShowContainer extends OpenStackRequest {

	private String containerName;
	
	public ShowContainer(String containerName) {
//		return target.path(containerName).request(MediaType.APPLICATION_JSON).head();
	}

}
