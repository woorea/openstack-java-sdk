package org.openstack.console.commands;


public class ListFloatingIps extends OpenstackCliCommandRunnerBase {
	public ListFloatingIps() {
		super("list", "floatingips");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().getComputeEndpoint().floatingIps().get();
	}

}
