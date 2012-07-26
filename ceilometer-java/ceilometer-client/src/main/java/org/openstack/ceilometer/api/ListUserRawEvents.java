package org.openstack.ceilometer.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.model.MeterEvents;

public class ListUserRawEvents implements CeilometerCommand<MeterEvents> {

	private String source;
	
	private String user;
	
	public ListUserRawEvents(String source, String user) {
		this.source = source;
		this.user = user;
	}

	@Override
	public MeterEvents execute(WebTarget target) {
		return target.path("sources").path("source").path("users").path(user).request(MediaType.APPLICATION_JSON).get(MeterEvents.class);
	}

}
