package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.SecurityGroupRuleForCreate;

import com.sun.jersey.api.client.Client;

public class SecurityGroupRulesResource extends Resource {

	public SecurityGroupRulesResource(Client client, String resource) {
		super(client, resource);
	}
	
	public SecurityGroupRuleForCreate create(SecurityGroupRuleForCreate securityGroupRule) {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).type(MediaType.APPLICATION_XML).post(SecurityGroupRuleForCreate.class, securityGroupRule);
	}
	
	public SecurityGroupRuleResource rule(String id) {
		return new SecurityGroupRuleResource(client, id);
	}

}
