package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.model.Image;

public class UpdateImage extends OpenStackRequest {

	private Image image;
	
	public UpdateImage(Image image) {
		method(HttpMethod.PUT);
	    path("/images/").path(image.getId());
	    header("Accept", "application/json");
	    json(image);
	    returnType(Image.class);
	}

}
