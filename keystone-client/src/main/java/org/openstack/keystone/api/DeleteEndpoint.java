package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.User;

public class DeleteEndpoint extends OpenStackRequest {
	
	public DeleteEndpoint(String id) {
		method(HttpMethod.DELETE);
	    path("/endpoints/").path(id);
	    header("Accept", "application/json");
	    returnType(User.class);
	}
	
}
