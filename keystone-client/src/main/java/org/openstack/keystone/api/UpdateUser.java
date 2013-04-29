package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.User;

public class UpdateUser extends OpenStackRequest {
	
	private User userForCreate;
	
	public UpdateUser(String id, User userForCreate) {
		this.userForCreate = userForCreate;
		
		method(HttpMethod.PUT);
		path("/users").path(id);
		json(userForCreate);
		header("Accept", "application/json");
		returnType(User.class);
	}
	
}
