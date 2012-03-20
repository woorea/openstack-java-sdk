package org.openstack.client.cli.commands;

import org.openstack.model.compute.NovaKeyPair;

public class ListKeypairs extends OpenstackCliCommandRunnerBase {
	public ListKeypairs() {
		super("list", "keypairs");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().compute().publicEndpoint().keyPairs().get();
	}
}
