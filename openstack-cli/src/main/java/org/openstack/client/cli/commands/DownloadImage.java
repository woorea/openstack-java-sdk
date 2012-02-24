package org.openstack.client.cli.commands;

import java.io.InputStream;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.model.GlanceImageName;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.utils.Io;

public class DownloadImage extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public GlanceImageName imageName;

	public DownloadImage() {
		super("download", "image");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackCliContext context = getContext();

		String imageId = imageName.findImageId(context);
		if (imageId == null) {
			throw new IllegalArgumentException("Cannot find image: " + imageName.getKey());
		}

		OpenstackImageClient client = context.buildImageClient();
		InputStream is = client.root().images().image(imageId).openStream();
		try {
			Io.copyStreams(is, System.out);
		} finally {
			Io.safeClose(is);
		}

		return null;
	}

}
