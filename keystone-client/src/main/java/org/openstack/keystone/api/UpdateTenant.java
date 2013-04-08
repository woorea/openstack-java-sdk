package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Tenant;

public class UpdateTenant implements KeystoneCommand<Tenant> {

	private Tenant tenant;
	
	public UpdateTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.PUT);
		request.path("/tenants").path(tenant.getId());
		request.header("Accept", "application/json");
		request.returnType(Tenant.class);
		return request;
	}
	
}
