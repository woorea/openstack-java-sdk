package org.openstack.ceilometer.api;

import java.math.BigDecimal;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MeterFunction extends MeterCommand<BigDecimal> {
	
	private String id;
	
	private String function;
	
	public MeterFunction(String id) {
		this.id = id;
	}
	
	public MeterFunction duration() {
		function = "duration";
		return this;
	}
	
	public MeterFunction volume() {
		function = "volume";
		return this;
	}
	
	public MeterFunction volumeMax() {
		function = "volume/max";
		return this;
	}
	
	public MeterFunction volumeSum() {
		function = "volume/sum";
		return this;
	}

	@Override
	public BigDecimal execute(WebTarget target) {
		if(source != null) {
			target = target.path("sources").path(source);
		} else if(project != null) {
			target = target.path("projects").path(project);
		} else if(user != null) {
			target = target.path("users").path(user);
		}
		target = target.path("v1/meters").path(id).path(function);
		Response response = target.request(MediaType.APPLICATION_JSON).get(Response.class);
		return null;
	}

}
