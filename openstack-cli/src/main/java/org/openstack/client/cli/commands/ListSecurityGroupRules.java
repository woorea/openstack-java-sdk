//package org.openstack.client.cli.commands;
//
//import org.kohsuke.args4j.Argument;
//import org.openstack.client.cli.OpenstackCliContext;
//import org.openstack.client.cli.model.SecurityGroupName;
//import org.openstack.client.compute.TenantResource;
//import org.openstack.model.compute.SecurityGroupList;
//
//public class ListSecurityGroupRules extends OpenstackCliCommandRunnerBase {
//    @Argument(index = 0)
//    public SecurityGroupName securityGroupName;
//
//    public ListSecurityGroupRules() {
//        super("list", "securitygrouprules");
//    }
//
//    @Override
//    public Object runCommand() throws Exception {
//        OpenstackCliContext context = getContext();
//        TenantResource tenant = context.getComputeClient();
//        SecurityGroupList sgs = tenant.securityGroups().list();
//        return sgs.getList();
//    }
//
// }
