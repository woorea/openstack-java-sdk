package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.model.InstanceName;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.model.compute.NovaServer;

public class DeleteInstance extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName instanceName;

	public DeleteInstance() {
		super("delete", "instance");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackCliContext context = getContext();

		String serverId = instanceName.findInstanceId(context);
		if (serverId == null) {
			throw new IllegalArgumentException("Cannot find instance: " + instanceName.getKey());
		}

		OpenstackComputeClient tenant = context.getComputeClient();
		tenant.root().servers().server(serverId).delete();

		invalidateCache(NovaServer.class);

		return serverId;
	}

}
