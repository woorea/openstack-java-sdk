package org.openstack.ceilometer.v1.api;

import java.util.List;

import org.openstack.ceilometer.v1.model.MeterEvent;

public class MeterShow extends MeterCommand<List<MeterEvent>> {
	
	private String id;
	
	public MeterShow(String id) {
		this.id = id;
		if(source != null) {
			path("sources").path(source);
		} else if(project != null) {
			path("projects").path(project);
		} else if(user != null) {
			path("users").path(user);
		}
		//return request.path("v1/meters").path(id).request(MediaType.APPLICATION_JSON).get(MeterEvents.class).getMeterEvents();
	}

}
