package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.OpenStackStorageClient;

public class CreateContainer extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public String name;

	public CreateContainer() {
		super("create", "container");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenStackStorageClient client = getStorageClient();

		client.publicEndpoint().container(name).put();
		return name;
	}

}
