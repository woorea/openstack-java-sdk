package org.openstack.client.cli.commands;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.compute.ImagesRepresentation;
import org.openstack.client.compute.TenantResource;

public class ListImages extends OpenstackCliCommandRunnerBase {

    public ListImages() {
        super("list", "images");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackCliContext context = getContext();
        TenantResource tenant = context.getComputeClient();
        ImagesRepresentation images = tenant.images().details();
        return images.getList();
    }

}
