package org.openstack.api.compute.ext;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.SecurityGroupRule;
import org.openstack.model.compute.nova.NovaCreateSecurityGroupRuleRequest;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupRule;

public class SecurityGroupRulesResource extends Resource {
	
	public SecurityGroupRulesResource(Target target) {
		super(target);
	}

    public SecurityGroupRule post(NovaCreateSecurityGroupRuleRequest rule) {
		// OSAPI bug: Can't specify an SSH key in XML?
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(rule, MediaType.APPLICATION_JSON), NovaSecurityGroupRule.class);
	}

    public SecurityGroupRuleResource rule(Integer id) {
    	return new SecurityGroupRuleResource(target.path("/{ruleId}").pathParam("ruleId", id));
    }

}
