package org.openstack.client.cli.commands;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.common.OpenstackImageClient;

public class ListGlanceImages extends OpenstackCliCommandRunnerBase {

    public ListGlanceImages() {
        super("list", "glanceimages");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackCliContext context = getContext();
        OpenstackImageClient client = context.buildImageClient();
        return client.root().images().list(true);
    }

}
