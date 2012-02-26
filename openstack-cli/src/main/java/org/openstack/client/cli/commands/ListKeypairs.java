package org.openstack.client.cli.commands;

import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.compute.ext.KeyPairsResource;

public class ListKeypairs extends OpenstackCliCommandRunnerBase {
    public ListKeypairs() {
        super("list", "keypairs");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient tenant = getComputeClient();
        return tenant.root().extension(KeyPairsResource.class).list();
    }

}
