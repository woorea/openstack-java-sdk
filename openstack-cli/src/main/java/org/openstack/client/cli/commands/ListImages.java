package org.openstack.client.cli.commands;

import org.openstack.client.common.OpenstackComputeClient;

public class ListImages extends OpenstackCliCommandRunnerBase {
    public ListImages() {
        super("list", "images");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient tenant = getComputeClient();
        return tenant.root().images().list(true);
    }

}
