package org.openstack.console.commands;


public class ListFlavors extends OpenstackCliCommandRunnerBase {
	public ListFlavors() {
		super("list", "flavors");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().getComputeEndpoint().flavors().get();
	}

}
