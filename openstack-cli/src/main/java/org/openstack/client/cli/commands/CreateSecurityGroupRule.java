package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.model.compute.CreateSecurityGroupRuleRequest;
import org.openstack.model.compute.SecurityGroupRule;

public class CreateSecurityGroupRule extends OpenstackCliCommandRunnerBase {
    @Argument(index = 0)
    public Integer securityGroupId;

    @Argument(index = 1)
    public String protocol;

    @Argument(index = 2)
    public String cidr;

    @Argument(index = 3)
    public Integer fromPort;
    @Argument(index = 4)
    public Integer toPort;

    public CreateSecurityGroupRule() {
        super("create", "securitygrouprule");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient compute = getComputeClient();

        CreateSecurityGroupRuleRequest newRule = new CreateSecurityGroupRuleRequest();
        newRule.setCidr(cidr);
        if (fromPort == null)
            fromPort = -1;
        newRule.setFromPort(fromPort);
        if (toPort == null)
            toPort = fromPort;
        newRule.setToPort(toPort);
        newRule.setIpProtocol(protocol);
        newRule.setParentGroupId(securityGroupId);

        SecurityGroupRule createdRule = compute.root().securityGroupRules().create(newRule);

        return createdRule;
    }

}
