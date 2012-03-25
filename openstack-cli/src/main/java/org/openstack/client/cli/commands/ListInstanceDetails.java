package org.openstack.client.cli.commands;

import java.util.HashMap;

import org.kohsuke.args4j.Argument;
import org.openstack.client.ComputeService;
import org.openstack.client.cli.model.InstanceName;

public class ListInstanceDetails extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName serverId;

	public ListInstanceDetails() {
		super("list", "instancedetails");
	}

	@Override
	public Object runCommand() throws Exception {
		ComputeService tenant = getContext().getComputeClient();
		// TODO: We don't format any extra details
		return tenant.getPublicEndpoint().servers().server(serverId.getKey()).get(new HashMap<String, Object>());
	}

}
