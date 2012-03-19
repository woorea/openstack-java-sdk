package org.openstack.api.compute.ext;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaSecurityGroupList;

public class SecurityGroupsResource extends Resource {
	
	public SecurityGroupsResource(Target target) {
		super(target);
	}

	@Override
	protected MediaType getDefaultContentType() {
		// Whitespace problems when using XML
		return MediaType.APPLICATION_JSON_TYPE;
	}

	public NovaSecurityGroupList get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).get(NovaSecurityGroupList.class);
	}
	
	public NovaSecurityGroup post(Entity<NovaSecurityGroup> securityGroup, HashMap<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).post(securityGroup, NovaSecurityGroup.class);
		
	}
	
	public SecurityGroupResource securityGroup(int id) {
		return new SecurityGroupResource(target.path("/{id}").pathParam("id", id));
	}
}
