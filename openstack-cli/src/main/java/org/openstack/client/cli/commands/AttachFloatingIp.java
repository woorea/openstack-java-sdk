package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.model.InstanceName;
import org.openstack.client.jersey2.OpenStackComputeClient;

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
		OpenStackComputeClient compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		compute.publicEndpoint().servers().server(instanceId).addFloatingIp(ip);
		return ip;
	}
}
