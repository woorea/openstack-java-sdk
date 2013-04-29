package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.model.Images;

public class ListImages extends OpenStackRequest {

	boolean detail;
	
	public ListImages(boolean detail) {
		method(HttpMethod.GET);
	    path(detail ? "/images/detail" : "images");
	    header("Accept", "application/json");
	    returnType(Images.class);
	}
	
	public ListImages() {
		this(false);
	}

}
