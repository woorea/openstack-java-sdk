package org.openstack.ceilometer.api;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.model.MeterEvent;
import org.openstack.ceilometer.model.MeterEvents;

public class MeterShow extends MeterCommand<List<MeterEvent>> {
	
	private String id;
	
	public MeterShow(String id) {
		this.id = id;
	}

	@Override
	public List<MeterEvent> execute(WebTarget target) {
		if(source != null) {
			target = target.path("sources").path(source);
		} else if(project != null) {
			target = target.path("projects").path(project);
		} else if(user != null) {
			target = target.path("users").path(user);
		}		
		return target.path("v1/meters").path(id).request(MediaType.APPLICATION_JSON).get(MeterEvents.class).getMeterEvents();
	}

}
