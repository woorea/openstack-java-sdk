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
		request.method("DELETE");
	    request.path("OS-KSADM/roles/").path(id);
	    request.header("Accept", "application/json");
		return null;
	}
	
}
