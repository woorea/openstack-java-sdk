package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.common.OpenstackComputeClient;
import org.openstack.client.cli.model.InstanceName;

public class GetConsoleOutput extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName instanceName;

	public GetConsoleOutput() {
		super("get", "consoleoutput");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackComputeClient compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		String output = compute.root().servers().server(instanceId).getConsoleOutput(null);

		return output;
	}

}
