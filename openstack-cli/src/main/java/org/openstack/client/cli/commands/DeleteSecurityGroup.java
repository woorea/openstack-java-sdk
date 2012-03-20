package org.openstack.client.cli.commands;

import java.util.HashMap;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.model.SecurityGroupName;
import org.openstack.model.compute.NovaSecurityGroup;

public class DeleteSecurityGroup extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public SecurityGroupName name;

	public DeleteSecurityGroup() {
		super("delete", "securitygroup");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackCliContext context = getContext();

		NovaSecurityGroup securityGroup = name.resolve(context);
		if (securityGroup == null) {
			throw new IllegalArgumentException("Cannot find security group: " + name.getKey());
		}

		getOpenstackService().compute().publicEndpoint().securityGroups().securityGroup(securityGroup.getId()).delete(new HashMap<String, Object>());

		return "" + securityGroup.getId();
	}

}
