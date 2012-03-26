package org.openstack.api.compute;

import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaFlavorList;

public class FlavorsResource extends Resource {
	
	public FlavorsResource(Target target) {
		super(target);
	}

    public NovaFlavorList get() {
		return target.path("/detail").request().get(NovaFlavorList.class);
    }

    public FlavorResource flavor(String id) {
    	return new FlavorResource(target.path("/{id}").pathParam("id", id));
    }

	

}
