package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.model.StoragePath;
import org.openstack.client.jersey2.OpenStackStorageClient;

public class DeleteFile extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public StoragePath path;

	public DeleteFile() {
		super("delete", "file");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenStackStorageClient client = getStorageClient();

		path.getResource(client).delete();

		return path.getKey();
	}

}
