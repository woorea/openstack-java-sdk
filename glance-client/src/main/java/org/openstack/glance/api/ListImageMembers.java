package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;
import org.openstack.glance.model.ImageMembers;

public class ListImageMembers implements GlanceCommand<ImageMembers>{
	
	private String id;
	
	public ListImageMembers(String id) {
		this.id = id;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
	    request.path("/images/").path(id).path("/members");
	    request.header("Accept", "application/json");
	    request.returnType(ImageMembers.class);
		return request;
	}

}
