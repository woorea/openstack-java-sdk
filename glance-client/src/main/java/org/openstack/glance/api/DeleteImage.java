package org.openstack.glance.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;

public class DeleteImage implements GlanceCommand<Void> {
	
	private String id;
	
	public DeleteImage(String id) {
		this.id = id;
	}

	@Override
	public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("DELETE");
	    request.path("/images/").path(id);
	    request.header("Accept", "application/json");
	    connector.execute(request);
	    return null;
	}
	
	
	
}
