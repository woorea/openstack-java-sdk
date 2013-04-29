package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;

public class DeleteUser extends OpenStackRequest {
	
	public DeleteUser(String id) {
		method(HttpMethod.DELETE);
	    path("/users/").path(id);
	    header("Accept", "application/json");
	}
	
}
