package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Roles;

public class ListRoles implements KeystoneCommand<Roles>{

	@Override
	public Roles execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("GET");
		request.path("/OS-KSADM/roles");
		request.header("Accept", "application/json");
		return connector.execute(request, Roles.class);
		//return target.path("OS-KSADM/roles").request(MediaType.APPLICATION_JSON).get(Roles.class);
	}

}
