package org.openstack.api.compute.notavailable;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

public class VolumeTypeResource extends Resource {

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

    protected VolumeTypeResource(Target target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	public void delete() {
    }

}
