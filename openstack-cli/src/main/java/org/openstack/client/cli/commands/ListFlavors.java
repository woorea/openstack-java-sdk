package org.openstack.client.cli.commands;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.compute.TenantResource;

public class ListFlavors extends OpenstackCliCommandRunnerBase {
    public ListFlavors() {
        super("list", "flavors");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackCliContext context = getContext();

        TenantResource tenant = context.getComputeClient();
        return tenant.flavors().details().getList();
    }

}
