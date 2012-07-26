package org.openstack.glance.api;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.Image;
import org.openstack.glance.model.ImageMember;

public class UpdateImage implements GlanceCommand<Image>{

	private Image image;
	
	public UpdateImage(Image image) {
		this.image = image;
	}
	
	@Override
	public Image execute(WebTarget endpoint) {
		return endpoint.path("images").path(image.getId()).request(MediaType.APPLICATION_JSON).put(Entity.json(image), Image.class);
	}

}
