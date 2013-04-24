package org.openstack.ceilometer.v1.api;

import java.util.List;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.v1.model.MeterEvent;

public class MeterList extends MeterCommand<List<MeterEvent>> {

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
		return null;
		//return target.path("v1/meters").request(MediaType.APPLICATION_JSON).get(MeterEvents.class).getMeterEvents();
	}

}
