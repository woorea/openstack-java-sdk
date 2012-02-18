package org.openstack.client.compute;

import com.sun.jersey.api.client.Client;

public abstract class RepresentationBase<T> {
    protected final Client client;

    protected final T model;

    public RepresentationBase(Client client, T model) {
        this.client = client;
        this.model = model;
    }

    public T getModel() {
        return model;
    }
}
