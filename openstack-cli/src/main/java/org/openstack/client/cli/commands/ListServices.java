package org.openstack.client.cli.commands;

import java.util.List;

import org.openstack.client.common.OpenstackSession;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Service;

public class ListServices extends OpenstackCliCommandRunnerBase {
    public ListServices() {
        super("list", "services");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackSession session = getOpenstackSession();
        Access access = session.getAuthenticationToken();

        List<Service> services = access.getServiceCatalog();
        return services;
    }
}
