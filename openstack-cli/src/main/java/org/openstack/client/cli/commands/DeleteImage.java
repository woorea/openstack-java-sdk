package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.model.ImageName;
import org.openstack.client.compute.TenantResource;

public class DeleteImage extends OpenstackCliCommandRunnerBase {
    @Argument(index = 0)
    public ImageName imageName;

    public DeleteImage() {
        super("delete", "image");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackCliContext context = getContext();

        String imageId = imageName.findImageId(context);
        if (imageId == null) {
            throw new IllegalArgumentException("Cannot find image: " + imageName.getKey());
        }

        TenantResource tenant = context.getComputeClient();
        tenant.images().image(imageId).delete();
        return imageId;
    }

}
