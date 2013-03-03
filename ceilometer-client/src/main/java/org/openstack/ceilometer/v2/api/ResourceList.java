package org.openstack.ceilometer.v2.api;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.CeilometerCommand;
import org.openstack.ceilometer.v2.model.Resource;

public class ResourceList implements CeilometerCommand<List<Resource>> {
		
	@Override
	public List<Resource> execute(WebTarget target) {
		return target.path("resources").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Resource>>() {});
	}

}