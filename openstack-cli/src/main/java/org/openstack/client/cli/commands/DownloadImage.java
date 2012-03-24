package org.openstack.client.cli.commands;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.model.GlanceImageName;
import org.openstack.client.jersey2.OpenStackImagesClient;
import org.openstack.model.image.glance.GlanceImage;

public class DownloadImage extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public GlanceImageName imageName;

	public DownloadImage() {
		super("download", "image");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackCliContext context = getContext();

		GlanceImage image = imageName.resolve(context);
		if (image == null) {
			throw new IllegalArgumentException("Cannot find image: " + imageName.getKey());
		}

		OpenStackImagesClient client = context.getImageClient();
		InputStream is = client.publicEndpoint().image(image.getId()).openStream();
		try {
			IOUtils.copy(is, System.out);
		} finally {
			IOUtils.closeQuietly(is);
		}

		return null;
	}

}
