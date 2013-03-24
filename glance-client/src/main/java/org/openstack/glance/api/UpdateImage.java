package org.openstack.glance.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.Image;

public class UpdateImage implements GlanceCommand<Image>{

	private Image image;
	
	public UpdateImage(Image image) {
		this.image = image;
	}
	
	@Override
	public Image execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("PUT");
	    request.path("/images/").path(image.getId());
	    request.header("Accept", "application/json");
	    request.json(image);
	    connector.execute(request, Image.class);
	    return null;
	}

}
