package org.openstack.client.compute;

import org.openstack.client.common.RequestBuilder;
import org.openstack.client.common.Resource;
import org.openstack.client.common.SimplePagingList;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.FlavorList;

public class FlavorsResource extends Resource {

    public Iterable<Flavor> list() {
        return list(true);
    }

    public Iterable<Flavor> list(boolean details) {
		RequestBuilder r = details ? resource("detail") : resource();
		FlavorList page = r.get(FlavorList.class);
		return new SimplePagingList<Flavor>(session, page);
    }

    public Flavor create(Flavor flavor) {
        return null;
    }

    public FlavorResource flavor(String id) {
        return buildChildResource(id, FlavorResource.class);
    }

}
