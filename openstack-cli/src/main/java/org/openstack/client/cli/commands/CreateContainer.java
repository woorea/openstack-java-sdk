package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.storage.OpenstackStorageClient;

public class CreateContainer extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public String name;

	public CreateContainer() {
		super("create", "container");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackStorageClient client = getStorageClient();

		client.root().containers().create(name);
		return name;
	}

}
