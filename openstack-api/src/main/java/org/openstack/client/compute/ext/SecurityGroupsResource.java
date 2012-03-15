package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaSecurityGroupList;

public class SecurityGroupsResource extends ComputeResourceBase {

	@Override
	protected MediaType getDefaultContentType() {
		// Whitespace problems when using XML
		return MediaType.APPLICATION_JSON_TYPE;
	}

	public NovaSecurityGroupList list() {
		return resource().get(NovaSecurityGroupList.class);
	}

	public NovaSecurityGroup create(NovaSecurityGroup securityGroup) {
		return resource().post(NovaSecurityGroup.class, securityGroup);
	}

	public SecurityGroupResource securityGroup(int id) {
		return buildChildResource(String.valueOf(id), SecurityGroupResource.class);
	}
}
