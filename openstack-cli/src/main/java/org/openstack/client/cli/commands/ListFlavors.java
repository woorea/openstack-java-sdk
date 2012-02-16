package org.openstack.client.cli.commands;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.compute.TenantResource;

public class ListFlavors extends OpenstackCliCommandRunnerBase {
    public ListFlavors() {
        super("list", "flavors");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient tenant = getComputeClient();
        return tenant.root().flavors().list(true);
    }

}
