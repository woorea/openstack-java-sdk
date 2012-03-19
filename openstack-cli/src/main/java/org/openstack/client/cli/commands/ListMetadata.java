package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.common.OpenstackComputeClient;
import org.openstack.client.cli.model.InstanceName;
import org.openstack.model.compute.NovaServer;

public class ListMetadata extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName instanceName;

	public ListMetadata() {
		super("list", "instancemetadata");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackComputeClient compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		NovaServer server = compute.root().servers().server(instanceId).show();
		return server.getMetadata().getItems();
	}

}
