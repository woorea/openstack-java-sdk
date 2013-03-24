package org.openstack.glance.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
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
	public ImageMember execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("PUT");
	    request.path("/images/").path(id).path("/members/").path(tenantId);
	    request.header("Accept", "application/json");
	    return connector.execute(request, ImageMember.class);
	}

}
