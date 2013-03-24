package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Service;

public class ShowService implements KeystoneCommand<Service>{
	
	private String id;
	
	public ShowService(String id) {
		this.id = id;
	}

	@Override
	public Service execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("GET");
		request.path("/OS-KSADM/services").path(id);
		request.header("Accept", "application/json");
		return connector.execute(request, Service.class);
		//return target.path("OS-KSADM/services").path(id).request(MediaType.APPLICATION_JSON).get(Service.class);
	}

}
