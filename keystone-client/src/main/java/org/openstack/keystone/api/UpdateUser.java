package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
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
	public User execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("GET");
		request.path("/users").path(id);
		request.json(userForCreate);
		request.header("Accept", "application/json");
		return connector.execute(request, User.class);
		//return target.path("users").path(id).request(MediaType.APPLICATION_JSON).put(Entity.json(userForCreate), User.class);
	}
	
}
