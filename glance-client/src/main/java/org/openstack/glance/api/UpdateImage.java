package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.model.Image;

public class UpdateImage implements OpenStackCommand<Image> {

	private Image image;
	
	public UpdateImage(Image image) {
		this.image = image;
	}
	
	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.PUT);
	    request.path("/images/").path(image.getId());
	    request.header("Accept", "application/json");
	    request.json(image);
	    request.returnType(Image.class);
	    return request;
	}

}
