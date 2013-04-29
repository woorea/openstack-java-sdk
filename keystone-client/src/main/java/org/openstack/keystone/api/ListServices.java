package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Services;

public class ListServices extends OpenStackRequest {

	public ListServices() {
		method(HttpMethod.GET);
		path("/OS-KSADM/services");
		header("Accept", "application/json");
		returnType(Services.class);
	}

}
