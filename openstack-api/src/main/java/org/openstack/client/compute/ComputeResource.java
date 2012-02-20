package org.openstack.client.compute;

import org.openstack.client.common.Resource;

public class ComputeResource extends Resource {

    public TenantResource tenant() {
        return new TenantResource(session, resource);
    }

}
