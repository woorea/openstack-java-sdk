package org.openstack.client.cli.commands;

import org.openstack.client.common.OpenstackComputeClient;

public class ListFloatingIps extends OpenstackCliCommandRunnerBase {
    public ListFloatingIps() {
        super("list", "floatingips");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient compute = getComputeClient();

        return compute.root().floatingIps().list();
    }

}
