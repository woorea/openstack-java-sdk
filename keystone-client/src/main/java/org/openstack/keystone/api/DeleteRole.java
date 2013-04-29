package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;

public class DeleteRole extends OpenStackRequest {

	public DeleteRole(String id) {
		method(HttpMethod.DELETE);
	    path("OS-KSADM/roles/").path(id);
	    header("Accept", "application/json");
	}
	
}
