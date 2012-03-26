package org.openstack.console.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.console.OpenstackCliContext;
import org.openstack.console.model.ImageName;
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

		getOpenstackService().getComputeEndpoint().images().image(image.getId()).delete();

		return image.getId();
	}

}
