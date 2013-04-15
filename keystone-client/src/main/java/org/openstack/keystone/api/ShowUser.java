package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.User;

public class ShowUser implements OpenStackCommand<User>{
	
	private String id;
	
	public ShowUser(String id) {
		this.id = id;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("/users").path(id);
		request.header("Accept", "application/json");
		request.returnType(User.class);
		return request;
	}

}
