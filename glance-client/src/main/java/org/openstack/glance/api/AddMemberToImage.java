package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.model.ImageMember;

public class AddMemberToImage implements OpenStackCommand<ImageMember> {

	private String id;
	
	private String tenantId;
	
	public AddMemberToImage(String id, String tenantId) {
		this.id = id;
		this.tenantId = tenantId;
	}
	
	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		request.method(HttpMethod.PUT);
	    request.path("/images/").path(id).path("/members/").path(tenantId);
	    request.header("Accept", "application/json");
	    request.returnType(ImageMember.class);
		return request;
	}

}
