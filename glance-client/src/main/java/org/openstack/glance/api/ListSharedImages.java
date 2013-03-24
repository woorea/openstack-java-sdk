package org.openstack.glance.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.SharedImages;

public class ListSharedImages implements GlanceCommand<SharedImages>{

	private String tenantId;
	
	public ListSharedImages(String tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public SharedImages execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("DELETE");
	    request.path("shared-images").path(tenantId);
	    request.header("Accept", "application/json");
	    return connector.execute(request, SharedImages.class);
	}

}
