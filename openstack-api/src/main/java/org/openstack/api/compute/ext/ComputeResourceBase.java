package org.openstack.api.compute.ext;

import org.openstack.api.common.Resource;
import org.openstack.client.RequestBuilder;

public abstract class ComputeResourceBase extends Resource {
    public ComputeResourceBase() {
    }

    protected <T> T post(Class<T> retClass, Object body) {
        RequestBuilder builder = resource();
        return builder.post(retClass, body);
    }

    protected <T> T put(Class<T> retClass, Object body) {
        RequestBuilder builder = resource();
        return builder.put(retClass, body);
    }
}
