package org.openstack.console.commands;

public class ListImages extends OpenstackCliCommandRunnerBase {
	public ListImages() {
		super("list", "images");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().compute().getPublicEndpoint().images().get();
	}
}
