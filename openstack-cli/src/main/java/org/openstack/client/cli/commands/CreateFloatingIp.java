package org.openstack.client.cli.commands;

import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.compute.ext.FloatingIpsResource;

public class CreateFloatingIp extends OpenstackCliCommandRunnerBase {

    public CreateFloatingIp() {
        super("create", "floatingip");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient compute = getComputeClient();

        return compute.root().extension(FloatingIpsResource.class).create();
    }

}
