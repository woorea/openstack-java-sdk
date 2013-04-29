package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;

public class DeleteImage extends OpenStackRequest {
	
	public DeleteImage(String id) {
		method(HttpMethod.DELETE);
	    path("/images/").path(id);
	    header("Accept", "application/json");
	}
	
}
