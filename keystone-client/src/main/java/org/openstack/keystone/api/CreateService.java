package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Service;

public class CreateService extends OpenStackRequest {

	private Service serviceForCreate;
	
	public CreateService(Service serviceForCreate) {
		method(HttpMethod.POST);
		path("OS-KSADM/services");
		json(serviceForCreate);
		header("Accept", "application/json");
		returnType(Service.class);
	}
	
}
