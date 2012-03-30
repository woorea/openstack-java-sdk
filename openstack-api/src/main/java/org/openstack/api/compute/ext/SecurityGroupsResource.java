package org.openstack.api.compute.ext;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupList;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroup;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupList;

public class SecurityGroupsResource extends Resource {
	
	public SecurityGroupsResource(Target target) {
		super(target);
	}

	public SecurityGroupList get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaSecurityGroupList.class);
	}
	
	public SecurityGroup post(NovaSecurityGroup securityGroup) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(securityGroup, MediaType.APPLICATION_JSON), NovaSecurityGroup.class);
		
	}
	
	public SecurityGroupResource securityGroup(int id) {
		return new SecurityGroupResource(target.path("/{id}").pathParam("id", id));
	}

	
}
