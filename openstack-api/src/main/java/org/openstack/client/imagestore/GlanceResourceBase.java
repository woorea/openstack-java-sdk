package org.openstack.client.imagestore;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

abstract class GlanceResourceBase extends Resource {
    public GlanceResourceBase() {
    }
    
	protected Builder addAcceptHeaders(Builder webResource) {
        // Glance only speaks JSON
        return webResource.accept(MediaType.APPLICATION_JSON);
    }
}
