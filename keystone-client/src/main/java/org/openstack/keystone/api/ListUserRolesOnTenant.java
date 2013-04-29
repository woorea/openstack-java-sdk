package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Roles;

public class ListUserRolesOnTenant implements OpenStackCommand<Roles> {
	
	private String tenantId;
	private String userId;
	
	public ListUserRolesOnTenant(String tenantId, String userId) {
		this.tenantId = tenantId;
		this.userId = userId;
	}

	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("/tenants").path(tenantId).path("/users").path(userId).path("/roles");
		request.header("Accept", "application/json");
		request.returnType(Roles.class);
		return request;
	}

}
