package org.openstack.console.commands;

import org.openstack.client.ComputeService;

public class CreateFloatingIp extends OpenstackCliCommandRunnerBase {

	public CreateFloatingIp() {
		super("create", "floatingip");
	}

	@Override
	public Object runCommand() throws Exception {
		ComputeService compute = getContext().getComputeClient();

		return compute.getPublicEndpoint().floatingIps().post();
	}

}
