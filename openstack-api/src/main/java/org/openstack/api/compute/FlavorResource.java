package org.openstack.api.compute;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaFlavor;

public class FlavorResource extends Resource {

	public FlavorResource(Target target) {
		super(target);
	}

	public NovaFlavor get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaFlavor.class);
	}

}
