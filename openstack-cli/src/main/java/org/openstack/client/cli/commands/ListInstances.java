package org.openstack.client.cli.commands;

import org.openstack.model.compute.NovaServer;

public class ListInstances extends OpenstackCliCommandRunnerBase {
	public ListInstances() {
		super("list", "instances");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().compute().publicEndpoint().servers().get();
	}

}
