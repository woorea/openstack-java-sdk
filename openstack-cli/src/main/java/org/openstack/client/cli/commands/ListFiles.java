package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.storage.OpenstackStorageClient;
import org.openstack.client.cli.model.StoragePath;

public class ListFiles extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public StoragePath path;

	public ListFiles() {
		super("list", "files");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackStorageClient client = getStorageClient();

		String containerName = path.getContainer();
		String objectPath = path.getObjectPath();

		String delimiter = null;
		return client.root().containers().id(containerName).objects().list(objectPath, delimiter);
	}

}
