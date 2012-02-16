package org.openstack.client.compute.ext;

import org.openstack.model.compute.SecurityGroupRuleForCreate;

public class SecurityGroupRulesResource extends ComputeResourceBase {

    public SecurityGroupRuleForCreate create(SecurityGroupRuleForCreate securityGroupRule) {
        return resource().post(SecurityGroupRuleForCreate.class, securityGroupRule);
    }

    public SecurityGroupRuleResource securityGroupRule(String id) {
        return buildChildResource(id, SecurityGroupRuleResource.class);
    }

}
