package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Roles;

public class ListRoles extends OpenStackRequest {

	public ListRoles() {
		method(HttpMethod.GET);
		path("/OS-KSADM/roles");
		header("Accept", "application/json");
		returnType(Roles.class);
	}

}
