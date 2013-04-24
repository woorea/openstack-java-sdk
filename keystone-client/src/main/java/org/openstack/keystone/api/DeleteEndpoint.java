package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.User;

public class DeleteEndpoint implements OpenStackCommand<Void> {

	private String id;
	
	public DeleteEndpoint(String id) {
		this.id = id;
	}

	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.DELETE);
	    request.path("/endpoints/").path(id);
	    request.header("Accept", "application/json");
	    request.returnType(User.class);
		return request;
	}
	
}
