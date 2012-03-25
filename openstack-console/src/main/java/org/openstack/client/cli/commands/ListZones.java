//package org.openstack.client.cli.commands;
//
//import org.openstack.client.cli.OpenstackCliContext;
//import org.openstack.client.compute.TenantResource;
//import org.openstack.model.compute.ZoneList;
//
//public class ListZones extends OpenstackCliCommandRunnerBase {
//
//    public ListZones() {
//        super("list", "zones");
//    }
//
//    @Override
//    public Object runCommand() throws Exception {
//        OpenstackCliContext context = getContext();
//        TenantResource tenant = context.getComputeClient();
//        ZoneList zones = tenant.zones().list();
//        return zones.getList();
//    }
//
// }
