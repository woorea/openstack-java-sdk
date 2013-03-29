package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;

public class DeleteUser implements KeystoneCommand<Void> {

	private String id;
	
	public DeleteUser(String id) {
		this.id = id;
	}

	@Override
	public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("DELETE");
	    request.path("/users/").path(id);
	    request.header("Accept", "application/json");
	    connector.execute(request);
	    return null;
	}
	
}
