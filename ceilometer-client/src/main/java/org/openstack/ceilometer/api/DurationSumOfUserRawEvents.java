package org.openstack.ceilometer.api;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.model.ResourceAggregations;

public class DurationSumOfUserRawEvents implements CeilometerCommand<ResourceAggregations> {

	private String source;
	
	private String user;
	
	private String meter;
	
	public DurationSumOfUserRawEvents(String source, String project, String meter) {
		this.source = source;
		this.user = project;
		this.meter = meter;
	}

	@Override
	public ResourceAggregations execute(WebTarget target) {
		return target.path("source").path("projects").path(user).path(meter).path("duration").request(MediaType.APPLICATION_JSON).get(ResourceAggregations.class);
	}

}