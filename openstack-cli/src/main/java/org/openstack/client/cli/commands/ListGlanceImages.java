package org.openstack.client.cli.commands;

import org.openstack.client.cli.OpenstackCliContext;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.client.imagestore.PagingList;
import org.openstack.model.image.Image;
import org.openstack.model.image.ImageList;

import com.google.common.collect.Lists;

public class ListGlanceImages extends OpenstackCliCommandRunnerBase {

    public ListGlanceImages() {
        super("list", "glanceimages");
    }

    @Override
    public Object runCommand() throws Exception {
        OpenstackCliContext context = getContext();
        OpenstackImageClient client = context.buildImageClient();
        PagingList<Image> images = client.root().images().list();
        return images;
    }

}
