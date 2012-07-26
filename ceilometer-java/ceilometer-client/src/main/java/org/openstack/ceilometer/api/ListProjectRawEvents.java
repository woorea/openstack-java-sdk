package org.openstack.ceilometer.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.model.MeterEvents;

public class ListProjectRawEvents implements CeilometerCommand<MeterEvents> {

	private String source;
	
	private String project;
	
	public ListProjectRawEvents(String source, String project) {
		this.source = source;
		this.project = project;
	}

	@Override
	public MeterEvents execute(WebTarget target) {
		return target.path("sources").path("source").path("projects").path(project).request(MediaType.APPLICATION_JSON).get(MeterEvents.class);
	}

}
