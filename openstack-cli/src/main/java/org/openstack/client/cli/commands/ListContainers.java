package org.openstack.client.cli.commands;

import java.util.HashMap;

import org.openstack.client.OpenStackStorageClient;

public class ListContainers extends OpenstackCliCommandRunnerBase {
	public ListContainers() {
		super("list", "containers");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenStackStorageClient client = getStorageClient();

		return client.publicEndpoint().containers().get(new HashMap<String, Object>());
	}

}
