package org.openstack.client.cli.commands;

public class ListSecurityGroups extends OpenstackCliCommandRunnerBase {
	public ListSecurityGroups() {
		super("list", "securitygroups");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().compute().publicEndpoint().securityGroups().get();
	}

}
