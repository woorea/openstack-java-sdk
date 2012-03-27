package org.openstack.console.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.compute.TenantResource;
import org.openstack.console.model.InstanceName;
import org.openstack.model.compute.nova.server.actions.Console;

public class RunVnc extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName instanceName;

	public RunVnc() {
		super("run", "vnc");
	}

	@Override
	public Object runCommand() throws Exception {
		TenantResource compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		String type = "novnc";
		Console console = compute.servers().server(instanceId).getVncConsole(type);

		return console;
	}

}
