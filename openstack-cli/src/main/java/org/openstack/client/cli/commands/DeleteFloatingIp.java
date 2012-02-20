package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.common.OpenstackComputeClient;

public class DeleteFloatingIp extends OpenstackCliCommandRunnerBase {
    @Argument(index = 0)
    public String id;

    public DeleteFloatingIp() {
        super("delete", "floatingip");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient compute = getComputeClient();

        compute.root().floatingIps().floatingIp(id).delete();

        return id;
    }
}
