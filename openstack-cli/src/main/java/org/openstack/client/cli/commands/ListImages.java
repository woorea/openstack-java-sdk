package org.openstack.client.cli.commands;

import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.compute.ImagesRepresentation;

public class ListImages extends OpenstackCliCommandRunnerBase {
    public ListImages() {
        super("list", "images");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient tenant = getComputeClient();
        ImagesRepresentation images = tenant.root().images().details();
        return images.asModels();
    }

}
