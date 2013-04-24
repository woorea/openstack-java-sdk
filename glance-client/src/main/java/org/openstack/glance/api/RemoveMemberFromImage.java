package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public class RemoveMemberFromImage implements OpenStackCommand<Void> {

	private String id;
	
	private String tenantId;
	
	public RemoveMemberFromImage(String id, String tenantId) {
		this.id = id;
		this.tenantId = tenantId;
	}
	
	@Override
	public OpenStackRequest createRequest(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.DELETE);
	    request.path("/images/").path(id).path("/members/").path(tenantId);
	    request.header("Accept", "application/json");
	    
	    return null;
	}

}
