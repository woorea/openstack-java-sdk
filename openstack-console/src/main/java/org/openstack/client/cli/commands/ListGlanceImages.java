package org.openstack.client.cli.commands;


public class ListGlanceImages extends OpenstackCliCommandRunnerBase {

	public ListGlanceImages() {
		super("list", "glanceimages");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().images().getPublicEndpoint().get();
	}

}
