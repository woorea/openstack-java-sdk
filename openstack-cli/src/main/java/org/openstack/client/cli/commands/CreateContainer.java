package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.StorageService;

public class CreateContainer extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public String name;

	public CreateContainer() {
		super("create", "container");
	}

	@Override
	public Object runCommand() throws Exception {
		StorageService client = getStorageClient();

		client.getPublicEndpoint().container(name).put();
		return name;
	}

}
