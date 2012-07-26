package org.openstack.ceilometer.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.model.Extensions;

public class ListExtensions implements CeilometerCommand<Extensions> {

	@Override
	public Extensions execute(WebTarget target) {
		return target.path("extensions").request(MediaType.APPLICATION_JSON).get(Extensions.class);
	}

}
