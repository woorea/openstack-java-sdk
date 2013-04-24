package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Role;

public class CreateRole implements OpenStackCommand<Role> {

	private Role roleForCreate;
	
	public CreateRole(Role roleForCreate) {
		this.roleForCreate = roleForCreate;
	}

	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.POST);
		request.path("/endpoints");
		request.json(roleForCreate);
		request.header("Accept", "application/json");
		request.returnType(Role.class);
		return request;
	}
	
}
