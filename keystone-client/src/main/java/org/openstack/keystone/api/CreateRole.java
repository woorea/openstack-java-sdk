package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;
import org.openstack.keystone.model.Role;

public class CreateRole implements KeystoneCommand<Role> {

	private Role roleForCreate;
	
	public CreateRole(Role roleForCreate) {
		this.roleForCreate = roleForCreate;
	}

	@Override
	public Role execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("POST");
		request.path("/endpoints");
		request.json(roleForCreate);
		request.header("Accept", "application/json");
		return connector.execute(request, Role.class);
		//return target.path("OS-KSADM/roles").request(MediaType.APPLICATION_JSON).post(Entity.json(roleForCreate), Role.class);
	}
	
}
