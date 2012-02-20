package org.openstack.client.cli.commands;

import org.openstack.client.common.OpenstackComputeClient;

public class ListInstances extends OpenstackCliCommandRunnerBase {
    public ListInstances() {
        super("list", "instances");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient tenant = getComputeClient();
        return tenant.root().servers().list(true);
    }

}
