package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.User;

public class CreateUser implements KeystoneCommand<User> {

	private User userForCreate;
	
	public CreateUser(User userForCreate) {
		this.userForCreate = userForCreate;
	}

	@Override
	public User execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("POST");
		request.path("/users");
		request.json(userForCreate);
		request.header("Accept", "application/json");
		return connector.execute(request, User.class);
		//return target.path("users").request(MediaType.APPLICATION_JSON).post(Entity.json(userForCreate), User.class);
	}
	
}
