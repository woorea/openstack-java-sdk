package org.openstack.console.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.compute.TenantResource;

public class DeleteFloatingIp extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public String id;

	public DeleteFloatingIp() {
		super("delete", "floatingip");
	}

	@Override
	public Object runCommand() throws Exception {
		TenantResource compute = getContext().getComputeClient();

		compute.floatingIps().floatingIp(id).delete();

		return id;
	}
}
