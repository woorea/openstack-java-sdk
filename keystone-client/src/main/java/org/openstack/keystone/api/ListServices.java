package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Services;

public class ListServices implements KeystoneCommand<Services>{

	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("/OS-KSADM/services");
		request.header("Accept", "application/json");
		request.returnType(Services.class);
		return request;
	}

}
