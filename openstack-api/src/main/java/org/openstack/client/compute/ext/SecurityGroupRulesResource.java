package org.openstack.client.compute.ext;

import org.openstack.client.common.ResourceExtension;
import org.openstack.model.compute.CreateSecurityGroupRuleRequest;
import org.openstack.model.compute.SecurityGroupRule;

public class SecurityGroupRulesResource extends ComputeResourceBase implements ResourceExtension {

    public SecurityGroupRule create(CreateSecurityGroupRuleRequest securityGroupRule) {
        return resource().post(SecurityGroupRule.class, securityGroupRule);
    }

    public SecurityGroupRuleResource securityGroupRule(String id) {
        return buildChildResource(id, SecurityGroupRuleResource.class);
    }

}
