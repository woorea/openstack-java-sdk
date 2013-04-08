package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Role;

public class CreateRole implements KeystoneCommand<Role> {

	private Role roleForCreate;
	
	public CreateRole(Role roleForCreate) {
		this.roleForCreate = roleForCreate;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.POST);
		request.path("/endpoints");
		request.json(roleForCreate);
		request.header("Accept", "application/json");
		request.returnType(Role.class);
		return request;
	}
	
}
