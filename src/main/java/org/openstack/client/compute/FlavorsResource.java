package org.openstack.client.compute;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.FlavorList;

import com.sun.jersey.api.client.Client;

public class FlavorsResource extends Resource {

    public FlavorsResource(Client client, String resource) {
        super(client, resource);
    }

    public FlavorsRepresentation list() {
        FlavorList list = client.resource(resource).accept(MediaType.APPLICATION_XML).get(FlavorList.class);
        return new FlavorsRepresentation(client, list);
    }

    public FlavorsRepresentation details() {
        FlavorList list = resource("detail").get(FlavorList.class);
        return new FlavorsRepresentation(client, list);
    }

    public Flavor create(Flavor flavor) {
        return null;
    }

    public FlavorResource flavor(String id) {
        return new FlavorResource(client, new StringBuilder(resource).append("/").append(id).toString());
    }

}
