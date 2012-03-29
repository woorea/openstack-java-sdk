package org.openstack.console.commands;

import org.openstack.api.compute.TenantResource;


public class CreateFloatingIp extends OpenstackCliCommandRunnerBase {

	public CreateFloatingIp() {
		super("create", "floatingip");
	}

	@Override
	public Object runCommand() throws Exception {
		TenantResource compute = getContext().getComputeClient();

		return compute.floatingIps().post(null);
	}

}
