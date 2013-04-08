package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.keystone.KeystoneCommand;

public class DeleteRole implements KeystoneCommand<Void> {

	private String id;
	
	public DeleteRole(String id) {
		this.id = id;
	}

	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.DELETE);
	    request.path("OS-KSADM/roles/").path(id);
	    request.header("Accept", "application/json");
		return request;
	}
	
}
