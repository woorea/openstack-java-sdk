package org.openstack.ceilometer.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.model.Sources;

public class SourceList implements CeilometerCommand<Sources> {

	@Override
	public Sources execute(WebTarget target) {
		return target.path("v1/sources").request(MediaType.APPLICATION_JSON).get(Sources.class);
	}

}
