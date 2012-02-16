package org.openstack.client.compute;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

public class MetadataResource extends Resource {

    public MetadataResource(Client client, String resource) {
        super(client, resource);
    }

}
