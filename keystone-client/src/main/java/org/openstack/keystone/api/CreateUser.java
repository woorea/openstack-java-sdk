package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.User;

public class CreateUser implements KeystoneCommand<User> {

	private User userForCreate;
	
	public CreateUser(User userForCreate) {
		this.userForCreate = userForCreate;
	}

	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.POST);
		request.path("/users");
		request.json(userForCreate);
		request.header("Accept", "application/json");
		request.returnType(User.class);
		return request;
	}
	
}
