package org.openstack.console.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.ComputeService;

public class DeleteFloatingIp extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public String id;

	public DeleteFloatingIp() {
		super("delete", "floatingip");
	}

	@Override
	public Object runCommand() throws Exception {
		ComputeService compute = getContext().getComputeClient();

		compute.getPublicEndpoint().floatingIps().floatingIp(id).delete();

		return id;
	}
}
