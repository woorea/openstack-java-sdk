package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.model.Service;

public class ShowService implements OpenStackCommand<Service>{
	
	private String id;
	
	public ShowService(String id) {
		this.id = id;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.GET);
		request.path("/OS-KSADM/services").path(id);
		request.header("Accept", "application/json");
		request.returnType(Service.class);
		return request;
	}

}
