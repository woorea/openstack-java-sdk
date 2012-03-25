package org.openstack.console.commands;

import org.openstack.client.StorageService;

public class ListContainers extends OpenstackCliCommandRunnerBase {
	public ListContainers() {
		super("list", "containers");
	}

	@Override
	public Object runCommand() throws Exception {
		StorageService client = getStorageClient();

		return client.getPublicEndpoint().get();
	}

}
