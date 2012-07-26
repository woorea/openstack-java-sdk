package org.openstack.nova.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.nova.NovaCommand;
import org.openstack.nova.model.Extensions;

public class ListExtensions implements NovaCommand<Extensions> {

	@Override
	public Extensions execute(WebTarget target) {
		return target.path("extensions").request(MediaType.APPLICATION_JSON).get(Extensions.class);
	}

}
