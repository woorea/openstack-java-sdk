package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.RequestBuilder;
import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.WebResource.Builder;

public abstract class ComputeResourceBase extends Resource {
    public ComputeResourceBase() {
    }

    protected <T> T post(Class<T> retClass, Object body) {
        RequestBuilder builder = resource().addAcceptType(MediaType.APPLICATION_XML_TYPE).setContentType(MediaType.APPLICATION_XML_TYPE);
        return builder.post(retClass, body);
    }

    protected <T> T put(Class<T> retClass, Object body) {
        RequestBuilder builder = resource().addAcceptType(MediaType.APPLICATION_XML_TYPE).setContentType(MediaType.APPLICATION_XML_TYPE);
        return builder.put(retClass, body);
    }
}
