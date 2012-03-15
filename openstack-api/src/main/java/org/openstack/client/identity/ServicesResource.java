package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.KeyStoneServiceList;

public class ServicesResource extends Resource {

	public KeyStoneServiceList list() {
		return resource().get(KeyStoneServiceList.class);
	}
	
//	public ServiceResource create(Service tenant) {
//		return null;
//	}
	
	public ServiceResource service(String id) {
		return buildChildResource(id, ServiceResource.class);
	}
	
}
