package org.openstack.glance.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.glance.GlanceCommand;

public class RemoveMemberFromImage implements GlanceCommand<Void>{

	private String id;
	
	private String tenantId;
	
	public RemoveMemberFromImage(String id, String tenantId) {
		this.id = id;
		this.tenantId = tenantId;
	}
	
	@Override
	public Void execute(WebTarget endpoint) {
		endpoint.path("images").path(id).path("members").path(tenantId).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}

}
