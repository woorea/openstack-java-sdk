package org.openstack.api.compute.ext;


import java.util.HashMap;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaServer;

public class SecurityGroupResource extends Resource  {
	
	public SecurityGroupResource(Target target) {
		super(target);
	}

	protected MediaType getDefaultContentType() {
		// Whitespace problems when using XML
		return MediaType.APPLICATION_JSON_TYPE;
	}

	public NovaSecurityGroup get(HashMap<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).get(NovaSecurityGroup.class);
	}

	public void delete(HashMap<String, Object> properties) {
		target.request().header("X-Auth-Token", properties.get("X-Auth-Token")).delete();
	}
}
