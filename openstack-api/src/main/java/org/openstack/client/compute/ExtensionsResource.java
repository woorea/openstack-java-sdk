package org.openstack.client.compute;

import org.openstack.client.compute.ext.ComputeResourceBase;
import org.openstack.model.compute.ExtensionList;

public class ExtensionsResource extends ComputeResourceBase {

    public ExtensionList list() {
        return resource().get(ExtensionList.class);
    }

    public ExtensionResource extension(String extensionAlias) {
        return buildChildResource(extensionAlias, ExtensionResource.class);
    }
}
