package org.openstack.ceilometer.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.model.Sources;

public class ListSources implements CeilometerCommand<Sources> {

	private String source;
	
	public ListSources(String source) {
		this.source = source;
	}

	@Override
	public Sources execute(WebTarget target) {
		return target.path("sources").request(MediaType.APPLICATION_JSON).get(Sources.class);
	}

}
