package org.openstack.client.imagestore;

import com.sun.jersey.api.client.Client;

public class GlanceRootResource extends GlanceResourceBase {
    public GlanceRootResource(Client client, String resource) {
        initialize(client, resource);
    }

    public ImagesResource images() {
        return getChildResource("images", ImagesResource.class);
    }

    public String getBaseUrl() {
        return resource;
    }

}
