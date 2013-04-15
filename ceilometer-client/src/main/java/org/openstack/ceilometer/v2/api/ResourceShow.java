package org.openstack.ceilometer.v2.api;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.ceilometer.v2.model.Resource;


public class ResourceShow implements OpenStackCommand<Resource> {

	private String id;
		
	public ResourceShow id(String id) {
		this.id = id;
		return this;
	}
	
	@Override
	public OpenStackRequest execute(OpenStackClient client) {
		OpenStackRequest request = client.newOpenStackRequest();
//		if(id == null) {
//			throw new UnsupportedOperationException("resource id is mandatory");
//		}
//		return target.path("resources").path(id).request(MediaType.APPLICATION_JSON).get(Resource.class);
		return null;
	}

}