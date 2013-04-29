package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.User;

public class ShowUser extends OpenStackRequest {
	
	public ShowUser(String id) {
		method(HttpMethod.GET);
		path("/users").path(id);
		header("Accept", "application/json");
		returnType(User.class);
	}

}
