package org.openstack.api.compute.ext;


import java.util.HashMap;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroup;

public class SecurityGroupResource extends Resource  {
	
	public SecurityGroupResource(Target target) {
		super(target);
	}

	public SecurityGroup get() {
		return get(new HashMap<String, Object>());
	}

	public SecurityGroup get(HashMap<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(NovaSecurityGroup.class);
	}

	public void delete() {
		target.request().delete();
	}

	
}
