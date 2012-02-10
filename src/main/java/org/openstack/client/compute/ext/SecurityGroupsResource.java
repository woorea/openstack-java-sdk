package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupList;

import com.sun.jersey.api.client.Client;

public class SecurityGroupsResource extends Resource {

	public SecurityGroupsResource(Client client, String resource) {
		super(client, resource);
	}
	
	public SecurityGroupList list() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(SecurityGroupList.class);
	}
	
	public SecurityGroup create(SecurityGroup securityGroup) {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).post(SecurityGroup.class, securityGroup);
	}
	
	public SecurityGroupResource securityGroup(int id) {
		return new SecurityGroupResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}

}
