package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Services;

public class ListServices implements KeystoneCommand<Services>{

	@Override
	public Services execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("GET");
		request.path("/OS-KSADM/services");
		request.header("Accept", "application/json");
		return connector.execute(request, Services.class);
		//return target.path("OS-KSADM/services").request(MediaType.APPLICATION_JSON).get(Services.class);
	}

}
