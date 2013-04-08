package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.SharedImages;

public class ListSharedImages implements GlanceCommand<SharedImages>{

	private String tenantId;
	
	public ListSharedImages(String tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
	    request.path("shared-images").path(tenantId);
	    request.header("Accept", "application/json");
	    request.returnType(SharedImages.class);
		return request;
	}

}
