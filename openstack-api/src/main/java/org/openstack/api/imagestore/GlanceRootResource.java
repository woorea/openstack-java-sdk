package org.openstack.api.imagestore;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.client.OpenStackSession;

public class GlanceRootResource extends Resource {
	
	public GlanceRootResource(Target target) {
		super(target);
	}
	
    public GlanceRootResource(OpenStackSession session, String resource) {
        initialize(session, resource);
    }

    public ImagesResource images() {
        return target("/images", ImagesResource.class);
    }

    public String getBaseUrl() {
        return resource;
    }

}
