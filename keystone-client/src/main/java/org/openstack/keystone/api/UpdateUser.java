package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.User;

public class UpdateUser implements KeystoneCommand<User> {

	private String id;
	
	private User userForCreate;
	
	public UpdateUser(String id, User userForCreate) {
		this.userForCreate = userForCreate;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.PUT);
		request.path("/users").path(id);
		request.json(userForCreate);
		request.header("Accept", "application/json");
		request.returnType(User.class);
		return request;
	}
	
}
