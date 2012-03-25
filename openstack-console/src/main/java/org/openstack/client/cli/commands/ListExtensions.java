package org.openstack.client.cli.commands;


public class ListExtensions extends OpenstackCliCommandRunnerBase {
	public ListExtensions() {
		super("list", "extensions");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().compute().getPublicEndpoint().extensions().get();
	}
}
