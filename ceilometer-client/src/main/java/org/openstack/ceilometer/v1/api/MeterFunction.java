package org.openstack.ceilometer.v1.api;

import java.math.BigDecimal;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;

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
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = new OpenStackRequest();
		if(source != null) {
			request.path("sources").path(source);
		} else if(project != null) {
			request.path("projects").path(project);
		} else if(user != null) {
			request.path("users").path(user);
		}
		request.path("v1/meters").path(id).path(function);
		//Response response = target.request(MediaType.APPLICATION_JSON).get(Response.class);
		return null;
	}

}
