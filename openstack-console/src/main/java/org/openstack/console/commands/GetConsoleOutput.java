package org.openstack.console.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.compute.TenantResource;
import org.openstack.console.model.InstanceName;

public class GetConsoleOutput extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName instanceName;

	public GetConsoleOutput() {
		super("get", "consoleoutput");
	}

	@Override
	public Object runCommand() throws Exception {
		TenantResource compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		String output = compute.servers().server(instanceId).getConsoleOutput(null);

		return output;
	}

}
