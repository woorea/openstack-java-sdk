package org.openstack.api.compute;

import org.openstack.api.common.Resource;

public class ComputeResource extends Resource {

    public TenantResource tenant() {
        return new TenantResource(session, resource);
    }

}
