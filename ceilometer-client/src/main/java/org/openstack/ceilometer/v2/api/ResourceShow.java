package org.openstack.ceilometer.v2.api;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;


public class ResourceShow extends OpenStackRequest {

	private String id;
		
	public ResourceShow id(String id) {
		this.id = id;
		return this;
	}
	
	public ResourceShow(OpenStackClient client) {
//		if(id == null) {
//			throw new UnsupportedOperationException("resource id is mandatory");
//		}
//		return target.path("resources").path(id).request(MediaType.APPLICATION_JSON).get(Resource.class);
	}

}