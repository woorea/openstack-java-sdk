package org.openstack.client.cli.commands;


public class ListFloatingIps extends OpenstackCliCommandRunnerBase {
	public ListFloatingIps() {
		super("list", "floatingips");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().compute().getPublicEndpoint().floatingIps().get();
	}

}
