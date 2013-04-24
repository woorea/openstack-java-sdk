package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class DeleteImage implements OpenStackCommand<Void> {
	
	private String id;
	
	public DeleteImage(String id) {
		this.id = id;
	}

	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.DELETE);
	    request.path("/images/").path(id);
	    request.header("Accept", "application/json");
	    
	    return null;
	}
	
	
	
}
