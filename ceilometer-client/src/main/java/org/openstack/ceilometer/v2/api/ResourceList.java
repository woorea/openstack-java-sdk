package org.openstack.ceilometer.v2.api;

import java.util.List;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.QueriableCeilometerCommand;
import org.openstack.ceilometer.v2.model.Resource;

public class ResourceList extends QueriableCeilometerCommand<ResourceList, List<Resource>> {
	
	@Override
	public List<Resource> execute(OpenStackClientConnector connector, OpenStackRequest request) {
		//return query(target.path("resources")).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Resource>>() {});
		return null;
	}

}