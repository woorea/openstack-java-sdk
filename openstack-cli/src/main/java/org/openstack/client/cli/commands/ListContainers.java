package org.openstack.client.cli.commands;

import org.openstack.client.jersey2.OpenStackStorageClient;

public class ListContainers extends OpenstackCliCommandRunnerBase {
	public ListContainers() {
		super("list", "containers");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenStackStorageClient client = getStorageClient();

		return client.publicEndpoint().get();
	}

}
