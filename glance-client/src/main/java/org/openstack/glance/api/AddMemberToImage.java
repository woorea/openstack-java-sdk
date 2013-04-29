package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.model.ImageMember;

public class AddMemberToImage extends OpenStackRequest {
	
	public AddMemberToImage(String id, String tenantId) {
		method(HttpMethod.PUT);
	    path("/images/").path(id).path("/members/").path(tenantId);
	    header("Accept", "application/json");
	    returnType(ImageMember.class);
	}

}
