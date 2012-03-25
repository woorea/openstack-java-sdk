package org.openstack.client.cli.commands;


public class ListServices extends OpenstackCliCommandRunnerBase {
	public ListServices() {
		super("list", "services");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().identity().getAdministationEndpoint().services().get();
	}
}
