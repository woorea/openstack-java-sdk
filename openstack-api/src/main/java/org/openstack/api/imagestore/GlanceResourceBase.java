package org.openstack.api.imagestore;

import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;

abstract class GlanceResourceBase extends Resource {
    public GlanceResourceBase() {
    }
    
	@Override
	protected MediaType getDefaultContentType() {
		// Glance only speaks JSON
        return MediaType.APPLICATION_JSON_TYPE;
	}
}
