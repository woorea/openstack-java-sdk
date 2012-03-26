package org.openstack.console.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.compute.TenantResource;
import org.openstack.console.OpenstackCliContext;
import org.openstack.console.model.InstanceName;

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

		TenantResource tenant = context.getComputeClient();
		tenant.servers().server(serverId).delete();

		return serverId;
	}

}
