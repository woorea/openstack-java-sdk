package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Roles;

public class ListRoles implements KeystoneCommand<Roles>{

	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("/OS-KSADM/roles");
		request.header("Accept", "application/json");
		request.returnType(Roles.class);
		return request;
	}

}
