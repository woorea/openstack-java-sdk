package org.openstack.console.commands;


public class ListExtensions extends OpenstackCliCommandRunnerBase {
	public ListExtensions() {
		super("list", "extensions");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().getComputeEndpoint().extensions().get();
	}
}
