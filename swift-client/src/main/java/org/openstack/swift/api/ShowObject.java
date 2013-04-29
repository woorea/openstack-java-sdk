package org.openstack.swift.api;

import org.openstack.base.client.OpenStackRequest;

public class ShowObject extends OpenStackRequest {

	private String containerName;
	
	private String objectName;
	
	public ShowObject(String containerName, String objectName) {
		this.containerName = containerName;
		this.objectName = objectName;
//		return target.path(containerName).path(objectName).request(MediaType.APPLICATION_JSON).head();
	}

}
