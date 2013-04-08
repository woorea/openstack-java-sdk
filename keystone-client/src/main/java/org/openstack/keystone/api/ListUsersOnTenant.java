package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Users;

public class ListUsersOnTenant implements KeystoneCommand<Users>{
	
	private String tenantId;
	
	public ListUsersOnTenant(String tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("tenants").path(tenantId).path("users");
		request.header("Accept", "application/json");
		request.returnType(Users.class);
		return request;
	}

}
