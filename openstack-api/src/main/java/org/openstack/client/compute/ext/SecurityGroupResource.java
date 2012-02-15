package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

public class SecurityGroupResource extends Resource {
	
	private SecurityGroupRulesResource rules;

	public SecurityGroupResource(Client client, String resource) {
		super(client, resource);
	}
	
	public String show() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(String.class);
	}
	
	public void delete() {
		client.resource(resource).accept(MediaType.APPLICATION_XML).delete();
	}
	
	public SecurityGroupRulesResource rules() {
		if(rules == null) {
			rules = new SecurityGroupRulesResource(client, new StringBuilder(resource).append("/os-security-group-rules").toString());
		}
		return rules;
	}

}
