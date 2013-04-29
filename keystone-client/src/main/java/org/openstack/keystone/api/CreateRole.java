package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Role;

public class CreateRole extends OpenStackRequest {

	private Role roleForCreate;
	
	public CreateRole(Role roleForCreate) {
		method(HttpMethod.POST);
		path("/endpoints");
		json(roleForCreate);
		header("Accept", "application/json");
		returnType(Role.class);
	}
	
}
