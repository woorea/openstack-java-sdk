package org.openstack.console.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.compute.TenantResource;
import org.openstack.console.model.InstanceName;

public class ListInstanceDetails extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName serverId;

	public ListInstanceDetails() {
		super("list", "instancedetails");
	}

	@Override
	public Object runCommand() throws Exception {
		TenantResource tenant = getContext().getComputeClient();
		// TODO: We don't format any extra details
		return tenant.servers().server(serverId.getKey()).get();
	}

}
