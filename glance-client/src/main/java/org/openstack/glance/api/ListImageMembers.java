package org.openstack.glance.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.ImageMembers;

public class ListImageMembers implements GlanceCommand<ImageMembers>{
	
	private String id;
	
	public ListImageMembers(String id) {
		this.id = id;
	}

	@Override
	public ImageMembers execute(WebTarget target) {
		target.path("images").path(id).path("members").request(MediaType.APPLICATION_JSON).get(ImageMembers.class);
		return null;
	}

}
