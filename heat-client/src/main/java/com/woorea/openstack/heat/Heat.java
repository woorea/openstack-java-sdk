package com.woorea.openstack.heat;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;

/**
 * Reference: http://api.openstack.org/api-ref-orchestration.html
 */
public class Heat extends OpenStackClient {

    private final StackResource stacks;

    public Heat(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        stacks = new StackResource(this);
    }

    public Heat(String endpoint) {
        this(endpoint, null);
    }

    public StackResource getStacks() {
        return stacks;
    }
}
