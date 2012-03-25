package org.openstack.console.commands;


public class ListKeypairs extends OpenstackCliCommandRunnerBase {
	public ListKeypairs() {
		super("list", "keypairs");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().compute().getPublicEndpoint().keyPairs().get();
	}
}
