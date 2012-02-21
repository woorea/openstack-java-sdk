package org.openstack.client.imagestore;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;

abstract class GlanceResourceBase extends Resource {
    public GlanceResourceBase() {
    }
    
	@Override
	protected MediaType getDefaultContentType() {
		// Glance only speaks JSON
        return MediaType.APPLICATION_JSON_TYPE;
	}
}
