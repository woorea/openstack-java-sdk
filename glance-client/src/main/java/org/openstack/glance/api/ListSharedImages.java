package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.model.SharedImages;

public class ListSharedImages extends OpenStackRequest {

	private String tenantId;
	
	public ListSharedImages(String tenantId) {
		method(HttpMethod.GET);
	    path("shared-images").path(tenantId);
	    header("Accept", "application/json");
	    returnType(SharedImages.class);
	}

}
