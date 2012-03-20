package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.OpenStackComputeClient;
import org.openstack.client.cli.model.InstanceName;
import org.openstack.model.compute.server.action.Console;

public class RunVnc extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName instanceName;

	public RunVnc() {
		super("run", "vnc");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenStackComputeClient compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		String type = "novnc";
		Console console = compute.publicEndpoint().servers().server(instanceId).getVncConsole(type);

		return console;
	}

}
