package org.openstack.console.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.storage.AccountResource;

public class CreateContainer extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public String name;

	public CreateContainer() {
		super("create", "container");
	}

	@Override
	public Object runCommand() throws Exception {
		AccountResource client = getStorageClient();

		client.container(name).put();
		return name;
	}

}
