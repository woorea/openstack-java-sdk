package org.openstack.client.imagestore;

import org.openstack.client.common.OpenStackSession;

public class GlanceRootResource extends GlanceResourceBase {
    public GlanceRootResource(OpenStackSession session, String resource) {
        initialize(session, resource);
    }

    public ImagesResource images() {
        return getChildResource("images", ImagesResource.class);
    }

    public String getBaseUrl() {
        return resource;
    }

}
