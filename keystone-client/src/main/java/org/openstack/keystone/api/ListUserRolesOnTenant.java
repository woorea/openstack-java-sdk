package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Roles;

public class ListUserRolesOnTenant implements KeystoneCommand<Roles> {
	
	private String tenantId;
	private String userId;
	
	public ListUserRolesOnTenant(String tenantId, String userId) {
		this.tenantId = tenantId;
		this.userId = userId;
	}

	@Override
	public Roles execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("GET");
		request.path("/tenants").path(tenantId).path("/users").path(userId).path("/roles");
		request.header("Accept", "application/json");
		return connector.execute(request, Roles.class);
		//return target.path("tenants").path(tenantId).path("users").path(userId).path("roles").request(MediaType.APPLICATION_JSON).get(Roles.class);
	}

}
