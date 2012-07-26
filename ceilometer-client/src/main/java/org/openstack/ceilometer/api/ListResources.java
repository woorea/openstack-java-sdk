package org.openstack.ceilometer.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.model.Resources;

public class ListResources implements CeilometerCommand<Resources> {

	private String source;
	
	public ListResources(String source) {
		this.source = source;
	}

	@Override
	public Resources execute(WebTarget target) {
		return target.path("source").path("resources").request(MediaType.APPLICATION_JSON).get(Resources.class);
	}

}
