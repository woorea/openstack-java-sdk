package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
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
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
	    request.path(detail ? "/images/detail" : "images");
	    request.header("Accept", "application/json");
	    request.returnType(Images.class);
		return request;
	}

}
