package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.model.InstanceName;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.model.compute.Server;

public class ListMetadata extends OpenstackCliCommandRunnerBase {
    @Argument(index = 0)
    public InstanceName instanceName;

    public ListMetadata() {
        super("list", "instancemetadata");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient compute = getComputeClient();

        String instanceId = instanceName.findInstanceId(getContext());

        Server server = compute.root().servers().server(instanceId).show();
        return server.getMetadata().getItems();
    }

}
