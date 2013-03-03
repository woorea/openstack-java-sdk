package org.openstack.ceilometer.v2.api;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.openstack.ceilometer.QueriableCeilometerCommand;
import org.openstack.ceilometer.v2.model.Resource;

public class ResourceList extends QueriableCeilometerCommand<ResourceList, List<Resource>> {
	
	@Override
	public List<Resource> execute(WebTarget target) {
		return query(target.path("resources")).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Resource>>() {});
	}

}