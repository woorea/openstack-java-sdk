package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.User;

public class ShowUser implements KeystoneCommand<User>{
	
	private String id;
	
	public ShowUser(String id) {
		this.id = id;
	}

	@Override
	public User execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("GET");
		request.path("/users").path(id);
		request.header("Accept", "application/json");
		return connector.execute(request, User.class);
		//return target.path("users").path(id).request(MediaType.APPLICATION_JSON).get(User.class);
	}

}
