package org.openstack.client.compute;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.Metadata;

public class ImageResource extends Resource {


    public Image show() {
        Image image = resource().get(Image.class);
        return image;
    }

    public void delete() {
        resource().delete();
    }

    public Metadata metadata() {
        // /metadata
        return new Metadata();
    }

}
