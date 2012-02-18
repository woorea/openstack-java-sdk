package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.model.FlavorName;
import org.openstack.client.cli.model.ImageName;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.compute.ServerRepresentation;
import org.openstack.client.compute.TenantResource;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerForCreate;

public class CreateInstance extends OpenstackCliCommandRunnerBase {
    @Argument(index = 0)
    public String instanceName;

    @Argument(index = 1)
    public ImageName imageName;

    @Argument(index = 2)
    public FlavorName flavorName;

    public CreateInstance() {
        super("create", "instance");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackCliContext context = getContext();

        String imageId = imageName.findImageId(context);
        if (imageId == null) {
            throw new IllegalArgumentException("Cannot find image: " + imageName.getKey());
        }

        String flavorId = flavorName.findImageId(context);
        if (flavorId == null) {
            throw new IllegalArgumentException("Cannot find flavor: " + flavorName.getKey());
        }

        OpenstackComputeClient tenant = context.getComputeClient();
        ServerForCreate serverForCreate = new ServerForCreate();
        serverForCreate.setName(instanceName);

        serverForCreate.setImageRef(imageId);
        serverForCreate.setFlavorRef(flavorId);

        return tenant.root().servers().create(serverForCreate);
    }

}
