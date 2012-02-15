package org.openstack.client.cli.commands;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.compute.TenantResource;
import org.openstack.model.compute.SecurityGroupList;

public class ListSecurityGroups extends OpenstackCliCommandRunnerBase {
    public ListSecurityGroups() {
        super("list", "securitygroups");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackCliContext context = getContext();
        TenantResource tenant = context.getComputeClient();
        SecurityGroupList sgs = tenant.securityGroups().list();
        return sgs.getList();
    }

}
