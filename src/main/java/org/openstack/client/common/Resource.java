package org.openstack.client.common;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource.Builder;

public class Resource {

    protected Client client;

    protected String resource;

    public Resource(Client client, String resource) {
        this.client = client;
        this.resource = resource;
    }

    protected Builder resource() {
        return client.resource(resource).accept(MediaType.APPLICATION_XML);
    }

    protected Builder resource(String relativePath) {
        String resourceUrl = resource;
        if (!resource.endsWith("/") && !relativePath.startsWith("/"))
            resourceUrl += "/";
        resourceUrl += relativePath;
        return client.resource(resourceUrl).accept(MediaType.APPLICATION_XML);
    }
}
