package org.openstack.client.cli.commands;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.model.StoragePath;
import org.openstack.client.jersey2.OpenStackStorageClient;

public class DownloadFile extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public StoragePath path;

	public DownloadFile() {
		super("download", "file");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenStackStorageClient client = getStorageClient();

		InputStream is = path.getResource(client).openStream();
		try {
			IOUtils.copy(is, System.out);
		} finally {
			IOUtils.closeQuietly(is);
		}

		return null;
	}

}
