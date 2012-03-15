package org.openstack.client.compute;

import org.openstack.client.common.RequestBuilder;
import org.openstack.client.common.Resource;
import org.openstack.client.common.SimplePagingList;
import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaFlavorList;

public class FlavorsResource extends Resource {

    public Iterable<NovaFlavor> list() {
        return list(true);
    }

    public Iterable<NovaFlavor> list(boolean details) {
		RequestBuilder r = details ? resource("detail") : resource();
		NovaFlavorList page = r.get(NovaFlavorList.class);
		return new SimplePagingList<NovaFlavor>(session, page);
    }

    public NovaFlavor create(NovaFlavor flavor) {
        return null;
    }

    public FlavorResource flavor(String id) {
        return buildChildResource(id, FlavorResource.class);
    }

}
