package org.openstack.console.commands;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.kohsuke.args4j.Argument;
import org.openstack.client.StorageService;
import org.openstack.console.model.StoragePath;

public class DownloadFile extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public StoragePath path;

	public DownloadFile() {
		super("download", "file");
	}

	@Override
	public Object runCommand() throws Exception {
		StorageService client = getStorageClient();

		InputStream is = path.getResource(client).openStream();
		try {
			IOUtils.copy(is, System.out);
		} finally {
			IOUtils.closeQuietly(is);
		}

		return null;
	}

}
