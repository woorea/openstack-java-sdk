package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;

public class DeleteImage implements GlanceCommand<Void> {
	
	private String id;
	
	public DeleteImage(String id) {
		this.id = id;
	}

	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.DELETE);
	    request.path("/images/").path(id);
	    request.header("Accept", "application/json");
	    
	    return null;
	}
	
	
	
}
