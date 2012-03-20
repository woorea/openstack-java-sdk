package org.openstack.client.cli.commands;

import java.util.HashMap;

import org.kohsuke.args4j.Argument;
import org.openstack.client.OpenStackComputeClient;
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
		OpenStackComputeClient compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		NovaServer server = compute.publicEndpoint().servers().server(instanceId).get(new HashMap<String, Object>());
		return server.getMetadata().getItems();
	}

}
