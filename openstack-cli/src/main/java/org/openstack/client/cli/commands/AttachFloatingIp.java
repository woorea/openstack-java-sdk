package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.common.OpenstackComputeClient;
import org.openstack.client.cli.model.InstanceName;

public class AttachFloatingIp extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName instanceName;

	@Argument(index = 1)
	public String ip;

	public AttachFloatingIp() {
		super("attach", "floatingip");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackComputeClient compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		compute.root().servers().server(instanceId).addFloatingIp(ip);
		return ip;
	}
}
