package org.openstack.client.cli.commands;

import java.util.HashMap;

import javax.ws.rs.client.Entity;

import org.kohsuke.args4j.Argument;
import org.openstack.client.OpenStackComputeClient;
import org.openstack.model.compute.NovaCreateSecurityGroupRuleRequest;
import org.openstack.model.compute.NovaSecurityGroupRule;

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
		OpenStackComputeClient compute = getContext().getComputeClient();

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

		NovaSecurityGroupRule createdRule = compute.publicEndpoint().securityGroupRules().post(new HashMap<String, Object>(), Entity.json(newRule));

		return createdRule;
	}

}
