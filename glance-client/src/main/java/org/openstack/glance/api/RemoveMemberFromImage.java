package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;

public class RemoveMemberFromImage extends OpenStackRequest {
	
	public RemoveMemberFromImage(String id, String tenantId) {
		method(HttpMethod.DELETE);
	    path("/images/").path(id).path("/members/").path(tenantId);
	    header("Accept", "application/json");
	}

}
