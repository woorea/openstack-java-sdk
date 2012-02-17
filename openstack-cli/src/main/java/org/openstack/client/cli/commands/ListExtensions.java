package org.openstack.client.cli.commands;

import org.openstack.client.common.OpenstackComputeClient;

public class ListExtensions extends OpenstackCliCommandRunnerBase {
    public ListExtensions() {
        super("list", "extensions");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient compute = getComputeClient();

        return compute.root().extensions().list();
    }
}
