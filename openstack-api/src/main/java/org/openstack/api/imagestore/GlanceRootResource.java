package org.openstack.api.imagestore;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

public class GlanceRootResource extends Resource {
	
	public GlanceRootResource(Target target) {
		super(target);
	}

    public ImagesResource images() {
        return path("/images", ImagesResource.class);
    }

}
