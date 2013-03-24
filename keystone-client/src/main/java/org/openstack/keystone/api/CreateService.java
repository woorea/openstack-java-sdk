package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Service;

public class CreateService implements KeystoneCommand<Service> {

	private Service serviceForCreate;
	
	public CreateService(Service serviceForCreate) {
		this.serviceForCreate = serviceForCreate;
	}

	@Override
	public Service execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("POST");
		request.path("OS-KSADM/services");
		request.json(serviceForCreate);
		request.header("Accept", "application/json");
		return connector.execute(request, Service.class);
		//return target.path("OS-KSADM/services").request(MediaType.APPLICATION_JSON).post(Entity.json(serviceForCreate), Service.class);
	}
	
}
