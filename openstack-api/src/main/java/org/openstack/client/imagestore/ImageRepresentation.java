package org.openstack.client.imagestore;

import org.openstack.model.image.GlanceImage;

import com.sun.jersey.api.client.Client;

public class ImageRepresentation {
    private final Client client;
    private final GlanceImage model;

    public ImageRepresentation(Client client, GlanceImage model) {
        this.client = client;
        this.model = model;
    }

    public GlanceImage getModel() {
        return model;
    }
}
