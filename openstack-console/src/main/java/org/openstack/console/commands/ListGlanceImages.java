package org.openstack.console.commands;


public class ListGlanceImages extends OpenstackCliCommandRunnerBase {

	public ListGlanceImages() {
		super("list", "glanceimages");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().getImagesEndpoint().get();
	}

}
