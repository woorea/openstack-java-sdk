package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Service;

public class ShowService extends OpenStackRequest {
	
	public ShowService(String id) {
		method(HttpMethod.GET);
		path("/OS-KSADM/services").path(id);
		header("Accept", "application/json");
		returnType(Service.class);
	}

}
