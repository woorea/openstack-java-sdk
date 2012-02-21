package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.model.compute.SecurityGroup;

public class SecurityGroupResource extends ComputeResourceBase {
	@Override
	protected MediaType getDefaultContentType() {
		// Whitespace problems when using XML
		return MediaType.APPLICATION_JSON_TYPE;
	}

	public SecurityGroup show() {
		return resource().get(SecurityGroup.class);
	}

	public void delete() {
		resource().delete();
	}
}
