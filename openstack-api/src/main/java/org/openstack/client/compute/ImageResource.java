package org.openstack.client.compute;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.Metadata;

import com.sun.jersey.api.client.Client;

public class ImageResource extends Resource {

    public ImageResource(Client client, String resource) {
        super(client, resource);
    }

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
