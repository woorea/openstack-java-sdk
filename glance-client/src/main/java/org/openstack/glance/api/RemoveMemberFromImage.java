package org.openstack.glance.api;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.GlanceCommand;

public class RemoveMemberFromImage implements GlanceCommand<Void>{

	private String id;
	
	private String tenantId;
	
	public RemoveMemberFromImage(String id, String tenantId) {
		this.id = id;
		this.tenantId = tenantId;
	}
	
	@Override
	public Void execute(OpenStackClientConnector connector, OpenStackRequest request) {
		request.method("DELETE");
	    request.path("/images/").path(id).path("/members/").path(tenantId);
	    request.header("Accept", "application/json");
	    connector.execute(request);
	    return null;
	}

}
