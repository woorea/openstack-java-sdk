package org.openstack.keystone.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;

public class DeleteTenant implements KeystoneCommand<Void> {

	private String id;
	
	public DeleteTenant(String id) {
		this.id = id;
	}

	@Override
	public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
		//target.path("tenants").path(id).request(MediaType.APPLICATION_JSON).delete();
		return null;
	}
	
}
