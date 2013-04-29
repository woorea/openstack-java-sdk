package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.model.ImageMembers;

public class ListImageMembers extends OpenStackRequest {
	
	private String id;
	
	public ListImageMembers(String id) {
		method(HttpMethod.GET);
	    path("/images/").path(id).path("/members");
	    header("Accept", "application/json");
	    returnType(ImageMembers.class);
	}

}
