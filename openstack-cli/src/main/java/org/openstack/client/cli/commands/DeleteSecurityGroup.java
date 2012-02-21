package org.openstack.client.cli.commands;

import org.kohsuke.args4j.Argument;
import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.common.OpenstackComputeClient;

public class DeleteSecurityGroup extends OpenstackCliCommandRunnerBase {
    @Argument(index = 0)
    public Integer id;

    public DeleteSecurityGroup() {
        super("delete", "securitygroup");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackCliContext context = getContext();

        OpenstackComputeClient tenant = context.getComputeClient();
        tenant.root().securityGroups().securityGroup(id).delete();
        return "" + id;
    }

}
