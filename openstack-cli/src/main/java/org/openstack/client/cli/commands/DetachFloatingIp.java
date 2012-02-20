package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.model.InstanceName;
import org.openstack.client.common.OpenstackComputeClient;

public class DetachFloatingIp extends OpenstackCliCommandRunnerBase {
    @Argument(index = 0)
    public InstanceName instanceName;

    @Argument(index = 1)
    public String ip;

    public DetachFloatingIp() {
        super("detach", "floatingip");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackComputeClient compute = getComputeClient();

        String instanceId = instanceName.findInstanceId(getContext());

        compute.root().servers().server(instanceId).removeFloatingIp(ip);

        return ip;
    }
}
