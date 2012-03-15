package org.openstack.client.compute;

import org.openstack.client.compute.ext.ComputeResourceBase;
import org.openstack.model.common.Extension;

public class ExtensionResource extends ComputeResourceBase {
    public Extension show() {
        return resource().get(Extension.class);
    }
}
