package org.openstack.client.cli.commands;

import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.compute.ServersRepresentation;

public class ListInstances extends OpenstackCliCommandRunnerBase {
    public ListInstances() {
        super("list", "instances");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient tenant = getComputeClient();
        ServersRepresentation servers = tenant.root().servers().list(true);
        return servers.asModels();
    }

}
