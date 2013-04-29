package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.User;

public class CreateUser extends OpenStackRequest {

	private User userForCreate;
	
	public CreateUser(User userForCreate) {
		this.userForCreate = userForCreate;
		method(HttpMethod.POST);
		path("/users");
		json(userForCreate);
		header("Accept", "application/json");
		returnType(User.class);
	}
	
}
