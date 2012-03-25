package org.openstack.client.cli.commands;


public class ListFlavors extends OpenstackCliCommandRunnerBase {
	public ListFlavors() {
		super("list", "flavors");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().compute().getPublicEndpoint().flavors().get();
	}

}
