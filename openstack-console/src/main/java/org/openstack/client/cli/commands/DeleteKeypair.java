package org.openstack.client.cli.commands;

import java.util.HashMap;

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
		tenant.getPublicEndpoint().keyPairs().keypair(id).delete(new HashMap<String, Object>());
		return id;
	}
}
