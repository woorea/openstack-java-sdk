package org.openstack.glance.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.ImageMember;

public class AddMemberToImage implements GlanceCommand<ImageMember>{

	private String id;
	
	private String tenantId;
	
	public AddMemberToImage(String id, String tenantId) {
		this.id = id;
		this.tenantId = tenantId;
	}
	
	@Override
	public ImageMember execute(WebTarget endpoint) {
		return endpoint.path("images").path(id).path("members").path(tenantId).request(MediaType.APPLICATION_JSON).method("PUT", ImageMember.class);
	}

}
