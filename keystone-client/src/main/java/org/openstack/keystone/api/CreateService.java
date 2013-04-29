package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Service;

public class CreateService implements OpenStackCommand<Service> {

	private Service serviceForCreate;
	
	public CreateService(Service serviceForCreate) {
		this.serviceForCreate = serviceForCreate;
	}

	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.POST);
		request.path("OS-KSADM/services");
		request.json(serviceForCreate);
		request.header("Accept", "application/json");
		request.returnType(Service.class);
		return request;
	}
	
}
