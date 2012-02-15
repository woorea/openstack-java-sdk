package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.cli.model.InstanceName;
import org.openstack.client.compute.ServerRepresentation;
import org.openstack.client.compute.TenantResource;

public class ListInstanceDetails extends OpenstackCliCommandRunnerBase {
    @Argument(index = 0)
    public InstanceName serverId;

    public ListInstanceDetails() {
        super("list", "instancedetails");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackCliContext context = getContext();
        TenantResource tenant = context.getComputeClient();
        // TODO: We don't format any extra details
        ServerRepresentation server = tenant.servers().server(serverId.getKey()).show();
        return server.getModel();
    }

}
