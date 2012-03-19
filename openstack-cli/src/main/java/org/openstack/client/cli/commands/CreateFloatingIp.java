package org.openstack.client.cli.commands;

import org.openstack.client.OpenstackComputeClient;

public class CreateFloatingIp extends OpenstackCliCommandRunnerBase {

	public CreateFloatingIp() {
		super("create", "floatingip");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackComputeClient compute = getContext().getComputeClient();

		return compute.root().floatingIps().create();
	}

}
