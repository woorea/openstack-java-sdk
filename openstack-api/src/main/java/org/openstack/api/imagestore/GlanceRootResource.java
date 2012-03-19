package org.openstack.api.imagestore;

import org.openstack.api.common.OpenStackSession;

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
