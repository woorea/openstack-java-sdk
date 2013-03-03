package org.openstack.ceilometer.v1.api;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.v1.model.MeterEvent;
import org.openstack.ceilometer.v1.model.MeterEvents;

public class MeterList extends MeterCommand<List<MeterEvent>> {

	@Override
	public List<MeterEvent> execute(WebTarget target) {
		if(source != null) {
			target = target.path("sources").path(source);
		} else if(project != null) {
			target = target.path("projects").path(project);
		} else if(user != null) {
			target = target.path("users").path(user);
		}
		return target.path("v1/meters").request(MediaType.APPLICATION_JSON).get(MeterEvents.class).getMeterEvents();
	}

}
