package org.openstack.api.compute;

import org.openstack.api.compute.ext.ComputeResourceBase;
import org.openstack.model.common.ExtensionList;

public class ExtensionsResource extends ComputeResourceBase {

    public ExtensionList list() {
        return resource().get(ExtensionList.class);
    }

    public ExtensionResource extension(String extensionAlias) {
        return buildChildResource(extensionAlias, ExtensionResource.class);
    }
}
