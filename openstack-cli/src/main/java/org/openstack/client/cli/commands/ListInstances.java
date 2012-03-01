package org.openstack.client.cli.commands;


public class ListInstances extends OpenstackCliCommandRunnerBase {
	public ListInstances() {
		super("list", "instances");
	}

	@Override
	public Object runCommand() throws Exception {
		return getCache().getInstances(false);
	}

}
