package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.common.OpenstackComputeClient;

public class DeleteKeypair extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public String id;

	public DeleteKeypair() {
		super("delete", "keypair");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackComputeClient tenant = getContext().getComputeClient();
		tenant.root().keyPairs().keypair(id).delete();
		return id;
	}
}
