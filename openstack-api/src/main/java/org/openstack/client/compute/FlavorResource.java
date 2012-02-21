package org.openstack.client.compute;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.Flavor;

public class FlavorResource extends Resource {

	private Flavor representation;

	public Flavor show() {
		return representation;
	}

	public FlavorResource get() {
		representation = resource().get(Flavor.class);
		return this;
	}

}
