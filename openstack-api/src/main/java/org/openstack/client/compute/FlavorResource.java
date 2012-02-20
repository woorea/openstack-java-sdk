package org.openstack.client.compute;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Flavor;

public class FlavorResource extends Resource {
	
	public Flavor show() {
		return resource().get(Flavor.class);
	}
	
}

