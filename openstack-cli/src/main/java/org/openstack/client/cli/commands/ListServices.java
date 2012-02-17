package org.openstack.client.cli.commands;

import java.util.List;

import org.openstack.client.common.OpenstackAuthenticationClient;
import org.openstack.client.common.OpenstackClient;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Service;

public class ListServices extends OpenstackCliCommandRunnerBase {
    public ListServices() {
        super("list", "services");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackClient openstackClient = getOpenstackClient();

        OpenstackAuthenticationClient authenticationClient = openstackClient.getAuthenticationClient();
        Access access = authenticationClient.getAuthenticationToken();

        List<Service> services = access.getServiceCatalog();
        return services;
    }
}
