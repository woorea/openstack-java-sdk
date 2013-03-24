package org.openstack.glance.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.ImageMembers;

public class ListImageMembers implements GlanceCommand<ImageMembers>{
	
	private String id;
	
	public ListImageMembers(String id) {
		this.id = id;
	}

	@Override
	public ImageMembers execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("DELETE");
	    request.path("/images/").path(id).path("/members");
	    request.header("Accept", "application/json");
	    return connector.execute(request, ImageMembers.class);
	}

}
