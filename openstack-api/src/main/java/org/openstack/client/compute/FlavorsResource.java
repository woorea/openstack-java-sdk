package org.openstack.client.compute;

import org.openstack.client.common.RequestBuilder;
import org.openstack.client.common.Resource;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaFlavorList;

public class FlavorsResource extends Resource {

    public NovaFlavorList list() {
        return list(true);
    }

    public NovaFlavorList list(boolean details) {
		RequestBuilder r = details ? resource("detail") : resource();
		return r.get(NovaFlavorList.class);
    }

    public NovaFlavor create(NovaFlavor flavor) {
        return null;
    }

    public FlavorResource flavor(String id) {
        return buildChildResource(id, FlavorResource.class);
    }

}
