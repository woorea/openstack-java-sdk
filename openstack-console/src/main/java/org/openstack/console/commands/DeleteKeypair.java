package org.openstack.console.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.ComputeService;

public class DeleteKeypair extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public String id;

	public DeleteKeypair() {
		super("delete", "keypair");
	}

	@Override
	public Object runCommand() throws Exception {
		ComputeService tenant = getContext().getComputeClient();
		tenant.getPublicEndpoint().keyPairs().keypair(id).delete();
		return id;
	}
}
