package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Tenant;

public class ShowTenant implements KeystoneCommand<Tenant>{
	
	private String id;
	
	public ShowTenant(String id) {
		this.id = id;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("/tenants").path(id);
		request.header("Accept", "application/json");
		request.returnType(Tenant.class);
		return request;
	}

}
