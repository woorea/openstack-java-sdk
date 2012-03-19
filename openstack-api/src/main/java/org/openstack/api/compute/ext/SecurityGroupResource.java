package org.openstack.api.compute.ext;


import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaSecurityGroup;

public class SecurityGroupResource extends Resource  {
	
	public SecurityGroupResource(Target target) {
		super(target);
	}

	protected MediaType getDefaultContentType() {
		// Whitespace problems when using XML
		return MediaType.APPLICATION_JSON_TYPE;
	}

	public NovaSecurityGroup show() {
		return resource().get(NovaSecurityGroup.class);
	}

	public void delete() {
		resource().delete();
	}
}
