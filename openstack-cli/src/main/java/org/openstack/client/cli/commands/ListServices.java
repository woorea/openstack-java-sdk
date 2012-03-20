package org.openstack.client.cli.commands;

import org.openstack.model.identity.KeyStoneService;

public class ListServices extends OpenstackCliCommandRunnerBase {
	public ListServices() {
		super("list", "services");
	}

	@Override
	public Object runCommand() throws Exception {
		return getOpenstackService().identity().publicEndpoint().services().get();
	}
}
