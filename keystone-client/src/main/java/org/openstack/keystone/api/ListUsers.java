package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Users;

public class ListUsers extends OpenStackRequest {

	public ListUsers() {
		method(HttpMethod.GET);
		path("/users");
		header("Accept", "application/json");
		returnType(Users.class);
	}

}
