package org.openstack.client.cli.commands;

import org.openstack.client.jersey2.OpenStackComputeClient;

public class CreateFloatingIp extends OpenstackCliCommandRunnerBase {

	public CreateFloatingIp() {
		super("create", "floatingip");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenStackComputeClient compute = getContext().getComputeClient();

		return compute.publicEndpoint().floatingIps().post();
	}

}
