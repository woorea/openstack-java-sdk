package org.openstack.client.cli.commands;

import org.openstack.client.storage.OpenstackStorageClient;

public class ListContainers extends OpenstackCliCommandRunnerBase {
	public ListContainers() {
		super("list", "containers");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackStorageClient client = getStorageClient();

		return client.root().containers().list();
	}

}
