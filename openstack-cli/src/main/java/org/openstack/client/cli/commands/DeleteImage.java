package org.openstack.client.cli.commands;

import java.util.HashMap;

import javax.ws.rs.client.Entity;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.model.ImageName;
import org.openstack.model.compute.NovaImage;

public class DeleteImage extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public ImageName imageName;

	public DeleteImage() {
		super("delete", "image");
	}

	@Override
	public Object runCommand() throws Exception {
		OpenstackCliContext context = getContext();

		NovaImage image = imageName.findImage(context);
		if (image == null) {
			throw new IllegalArgumentException("Cannot find image: " + imageName.getKey());
		}

		getOpenstackService().delete(new HashMap<String, Object>(), Entity.json(image));

		return image.getId();
	}

}
