package org.openstack.client.cli.commands;

public class ListImages extends OpenstackCliCommandRunnerBase {
	public ListImages() {
		super("list", "images");
	}

	@Override
	public Object runCommand() throws Exception {
		return getCache().getImages(false);
	}
}
