package org.openstack.console.commands;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.kohsuke.args4j.Argument;
import org.openstack.api.images.ImagesResource;
import org.openstack.console.OpenstackCliContext;
import org.openstack.console.model.GlanceImageName;
import org.openstack.model.images.Image;

public class DownloadImage extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public GlanceImageName imageName;

	public DownloadImage() {
		super("download", "image");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackCliContext context = getContext();

		Image image = imageName.resolve(context);
		if (image == null) {
			throw new IllegalArgumentException("Cannot find image: " + imageName.getKey());
		}

		ImagesResource client = context.getImageClient();
		InputStream is = client.image(image.getId()).openStream();
		try {
			IOUtils.copy(is, System.out);
		} finally {
			IOUtils.closeQuietly(is);
		}

		return null;
	}

}
