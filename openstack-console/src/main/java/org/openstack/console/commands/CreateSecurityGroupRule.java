package org.openstack.console.commands;

import javax.ws.rs.client.Entity;

import org.kohsuke.args4j.Argument;
import org.openstack.api.compute.TenantResource;
import org.openstack.model.compute.SecurityGroupRule;
import org.openstack.model.compute.nova.NovaCreateSecurityGroupRuleRequest;

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
		TenantResource compute = getContext().getComputeClient();

		NovaCreateSecurityGroupRuleRequest newRule = new NovaCreateSecurityGroupRuleRequest();
		newRule.setCidr(cidr);
		if (fromPort == null)
			fromPort = -1;
		newRule.setFromPort(fromPort);
		if (toPort == null)
			toPort = fromPort;
		newRule.setToPort(toPort);
		newRule.setIpProtocol(protocol);
		newRule.setParentGroupId(securityGroupId);

		SecurityGroupRule createdRule = compute.securityGroupRules().post(newRule);

		return createdRule;
	}

}
