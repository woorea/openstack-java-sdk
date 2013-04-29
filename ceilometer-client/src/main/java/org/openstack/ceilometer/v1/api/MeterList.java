package org.openstack.ceilometer.v1.api;

import java.util.List;

import org.openstack.ceilometer.v1.model.MeterEvent;

public class MeterList extends MeterCommand<List<MeterEvent>> {

	public MeterList() {
		if(source != null) {
			path("sources").path(source);
		} else if(project != null) {
			path("projects").path(project);
		} else if(user != null) {
			path("users").path(user);
		}
		//return target.path("v1/meters").request(MediaType.APPLICATION_JSON).get(MeterEvents.class).getMeterEvents();
	}

}
