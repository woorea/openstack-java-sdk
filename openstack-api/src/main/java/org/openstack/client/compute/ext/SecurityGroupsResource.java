package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.ResourceExtension;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupList;

public class SecurityGroupsResource extends ComputeResourceBase implements ResourceExtension {

	@Override
	protected MediaType getDefaultContentType() {
		// Whitespace problems when using XML
		return MediaType.APPLICATION_JSON_TYPE;
	}

	public SecurityGroupList list() {
		return resource().get(SecurityGroupList.class);
	}

	public SecurityGroup create(SecurityGroup securityGroup) {
		return resource().post(SecurityGroup.class, securityGroup);
	}

	public SecurityGroupResource securityGroup(int id) {
		return buildChildResource(String.valueOf(id), SecurityGroupResource.class);
	}
}
