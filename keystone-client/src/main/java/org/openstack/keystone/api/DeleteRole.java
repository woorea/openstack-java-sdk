package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;

public class DeleteRole implements KeystoneCommand<Void> {

	private String id;
	
	public DeleteRole(String id) {
		this.id = id;
	}

	@Override
	public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
		//target.path("OS-KSADM/roles").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}
	
}
