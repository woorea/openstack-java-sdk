package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
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
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
		request.method(HttpMethod.DELETE);
	    request.path("/images/").path(id).path("/members/").path(tenantId);
	    request.header("Accept", "application/json");
	    
	    return null;
	}

}
