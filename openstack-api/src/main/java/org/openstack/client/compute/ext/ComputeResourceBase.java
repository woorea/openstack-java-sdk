package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.WebResource.Builder;

public abstract class ComputeResourceBase extends Resource {
    public ComputeResourceBase() {
    }

    protected <T> T post(Class<T> retClass, Object body) {
        Builder builder = resource().type(MediaType.APPLICATION_XML);
        return builder.post(retClass, body);
    }

    protected <T> T put(Class<T> retClass, Object body) {
        Builder builder = resource().type(MediaType.APPLICATION_XML);
        return builder.put(retClass, body);
    }
}
