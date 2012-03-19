package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.common.OpenstackComputeClient;
import org.openstack.client.cli.model.InstanceName;

public class ListInstanceDetails extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName serverId;

	public ListInstanceDetails() {
		super("list", "instancedetails");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackComputeClient tenant = getContext().getComputeClient();
		// TODO: We don't format any extra details
		return tenant.root().servers().server(serverId.getKey()).show();
	}

}
