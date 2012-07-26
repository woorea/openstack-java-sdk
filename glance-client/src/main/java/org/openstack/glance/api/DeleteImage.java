package org.openstack.glance.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.glance.GlanceCommand;

public class DeleteImage implements GlanceCommand<Void> {
	
	private String id;
	
	public DeleteImage(String id) {
		this.id = id;
	}

	@Override
	public Void execute(WebTarget target) {
		target.path("images").path(id).request(MediaType.WILDCARD).delete();
		return null;
	}
	
	
	
}
