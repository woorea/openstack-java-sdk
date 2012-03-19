package org.openstack.api.compute;

import org.openstack.api.compute.ext.ComputeResourceBase;
import org.openstack.model.common.Extension;

public class ExtensionResource extends ComputeResourceBase {
    public Extension show() {
        return resource().get(Extension.class);
    }
}
