package org.openstack.client.cli.commands;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.compute.ServersRepresentation;
import org.openstack.client.compute.TenantResource;

public class ListInstances extends OpenstackCliCommandRunnerBase {
    public ListInstances() {
        super("list", "instances");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackCliContext context = getContext();
        TenantResource tenant = context.getComputeClient();
        ServersRepresentation servers = tenant.servers().list(true);
        return servers.getList();
    }

}
