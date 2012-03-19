package org.openstack.api.compute.ext;

import org.openstack.model.compute.NovaCreateSecurityGroupRuleRequest;
import org.openstack.model.compute.NovaSecurityGroupRule;

public class SecurityGroupRulesResource extends ComputeResourceBase {

    public NovaSecurityGroupRule create(NovaCreateSecurityGroupRuleRequest securityGroupRule) {
        return resource().post(NovaSecurityGroupRule.class, securityGroupRule);
    }

    public SecurityGroupRuleResource securityGroupRule(String id) {
        return buildChildResource(id, SecurityGroupRuleResource.class);
    }

}
