package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.model.InstanceName;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.compute.ImagesRepresentation;
import org.openstack.client.compute.TenantResource;

public class ListImages extends OpenstackCliCommandRunnerBase {
    public ListImages() {
        super("list", "images");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient tenant = getComputeClient();
        ImagesRepresentation images = tenant.root().images().details();
        return images.getList();
    }

}
