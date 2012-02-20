package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.ServiceList;

public class ServicesResource extends Resource {

	public ServiceList list() {
		return resource().get(ServiceList.class);
	}
	
//	public ServiceResource create(Service tenant) {
//		return null;
//	}
	
	public ServiceResource service(String id) {
		return buildChildResource(id, ServiceResource.class);
	}
	
}
