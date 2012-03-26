package org.openstack.console.commands;

import org.openstack.api.storage.AccountResource;


public class ListContainers extends OpenstackCliCommandRunnerBase {
	public ListContainers() {
		super("list", "containers");
	}

	@Override
	public Object runCommand() throws Exception {
		AccountResource client = getStorageClient();

		return client.get();
	}

}
