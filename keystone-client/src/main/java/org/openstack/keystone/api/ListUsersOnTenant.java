package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Users;

public class ListUsersOnTenant implements KeystoneCommand<Users>{
	
	private String tenantId;
	
	public ListUsersOnTenant(String tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public Users execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("GET");
		request.path("tenants").path(tenantId).path("users");
		request.header("Accept", "application/json");
		return connector.execute(request, Users.class);
		//return target.path("tenants").path(tenantId).path("users").request(MediaType.APPLICATION_JSON).get(Users.class);
	}

}
