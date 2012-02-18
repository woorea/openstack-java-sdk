package org.openstack.client.compute.ext;

import org.openstack.model.compute.CreateSecurityGroupRuleRequest;

public class SecurityGroupRulesResource extends ComputeResourceBase {

    public CreateSecurityGroupRuleRequest create(CreateSecurityGroupRuleRequest securityGroupRule) {
        return resource().post(CreateSecurityGroupRuleRequest.class, securityGroupRule);
    }

    public SecurityGroupRuleResource securityGroupRule(String id) {
        return buildChildResource(id, SecurityGroupRuleResource.class);
    }

}
