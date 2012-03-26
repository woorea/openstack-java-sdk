package org.openstack.console.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.api.storage.AccountResource;
import org.openstack.console.model.StoragePath;

public class ListFiles extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public StoragePath path;

	public ListFiles() {
		super("list", "files");
	}

	@Override
	public Object runCommand() throws Exception {
		AccountResource client = getStorageClient();

		String containerName = path.getContainer();
		String objectPath = path.getObjectPath();

		String delimiter = null;
		return client.container(containerName).get(objectPath, delimiter);
	}

}
