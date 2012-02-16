package org.openstack.client.compute.ext;

import org.openstack.model.compute.SecurityGroup;

public class SecurityGroupResource extends ComputeResourceBase {

    public SecurityGroup show() {
        return resource().get(SecurityGroup.class);
    }

    public void delete() {
        resource().delete();
    }
}
