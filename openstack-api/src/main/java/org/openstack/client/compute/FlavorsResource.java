package org.openstack.client.compute;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.FlavorList;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource.Builder;

public class FlavorsResource extends Resource {

    public FlavorsResource(Client client, String resource) {
        super(client, resource);
    }

    public FlavorsRepresentation list() {
        return list(true);
    }

    public FlavorsRepresentation list(boolean details) {
        Builder r = details ? resource("detail") : resource();
        return new FlavorsRepresentation(client, r.get(FlavorList.class));
    }

    public Flavor create(Flavor flavor) {
        return null;
    }

    public FlavorResource flavor(String id) {
        return new FlavorResource(client, new StringBuilder(resource).append("/").append(id).toString());
    }

}
