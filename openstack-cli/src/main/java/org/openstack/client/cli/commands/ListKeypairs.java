package org.openstack.client.cli.commands;

import org.openstack.client.common.OpenstackComputeClient;

public class ListKeypairs extends OpenstackCliCommandRunnerBase {
    public ListKeypairs() {
        super("list", "keypairs");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient tenant = getComputeClient();
        return tenant.root().keyPairs().list();
    }

}
