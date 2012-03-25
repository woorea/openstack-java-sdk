package org.openstack.console.commands;


public class ListInstances extends OpenstackCliCommandRunnerBase {
	public ListInstances() {
		super("list", "instances");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().compute().getPublicEndpoint().servers().get();
	}

}
