package org.openstack.client.cli.commands;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.compute.ext.SecurityGroupsResource;
import org.openstack.model.compute.SecurityGroupList;

public class ListSecurityGroups extends OpenstackCliCommandRunnerBase {
    public ListSecurityGroups() {
        super("list", "securitygroups");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackCliContext context = getContext();
        OpenstackComputeClient tenant = context.getComputeClient();
        SecurityGroupList sgs = tenant.root().extension(SecurityGroupsResource.class).list();
        return sgs.getList();
    }

}
