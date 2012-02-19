package org.openstack.client.compute;

import org.openstack.client.common.PagingList;
import org.openstack.model.common.PagingListBase;
import org.openstack.model.compute.Flavor;

import com.sun.jersey.api.client.Client;

public class FlavorsRepresentation extends PagingList<Flavor, FlavorRepresentation> {

    public FlavorsRepresentation(Client client, PagingListBase<Flavor> page) {
        super(client, page);
    }

    @Override
    protected FlavorRepresentation mapToRepresentation(Flavor model) {
        return new FlavorRepresentation(client, model);
    }

}
