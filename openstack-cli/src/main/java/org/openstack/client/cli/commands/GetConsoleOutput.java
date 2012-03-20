package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.OpenStackComputeClient;
import org.openstack.client.cli.model.InstanceName;

public class GetConsoleOutput extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName instanceName;

	public GetConsoleOutput() {
		super("get", "consoleoutput");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenStackComputeClient compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		String output = compute.publicEndpoint().servers().server(instanceId).getConsoleOutput(null);

		return output;
	}

}
