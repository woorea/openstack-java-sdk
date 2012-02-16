package org.openstack.client.compute.notavailable;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

public class VolumeTypeResource extends Resource {

    public VolumeTypeResource(Client client, String resource) {
        super(client, resource);
    }

    // /**
    // * Return a single volume type item.
    // *
    // * @return
    // */
    // public FlavorsRepresentation show() {
    // FlavorList list = client.resource(resource)
    // .accept(MediaType.APPLICATION_XML).get(FlavorList.class);
    // return new FlavorsRepresentation(client, list);
    // }

    public void delete() {
    }

}
