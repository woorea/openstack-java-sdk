package org.openstack.keystone.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackRequest;

public class DeleteService extends OpenStackRequest {
	
	public DeleteService(String id) {
		method(HttpMethod.DELETE);
	    path("/OS-KSADM/services/").path(id);
	    header("Accept", "application/json");
	}
	
}
