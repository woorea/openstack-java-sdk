package org.openstack.console.commands;

public class ListSecurityGroups extends OpenstackCliCommandRunnerBase {
	public ListSecurityGroups() {
		super("list", "securitygroups");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().compute().getPublicEndpoint().securityGroups().get();
	}

}
