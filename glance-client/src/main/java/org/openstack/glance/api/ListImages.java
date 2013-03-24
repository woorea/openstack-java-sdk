package org.openstack.glance.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.Images;

public class ListImages implements GlanceCommand<Images> {

	boolean detail;
	
	public ListImages(boolean detail) {
		this.detail = detail;
	}
	
	public ListImages() {
		this(false);
	}

	@Override
	public Images execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("DELETE");
	    request.path(detail ? "/images/detail" : "images");
	    request.header("Accept", "application/json");
	    return connector.execute(request, Images.class);
	}

}
