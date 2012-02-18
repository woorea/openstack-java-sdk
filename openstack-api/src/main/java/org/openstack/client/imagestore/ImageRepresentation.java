package org.openstack.client.imagestore;

import org.openstack.model.image.Image;

import com.sun.jersey.api.client.Client;

public class ImageRepresentation {
    private final Client client;
    private final Image model;

    public ImageRepresentation(Client client, Image model) {
        this.client = client;
        this.model = model;
    }

    public Image getModel() {
        return model;
    }
}
