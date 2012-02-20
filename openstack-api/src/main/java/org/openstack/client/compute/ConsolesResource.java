package org.openstack.client.compute;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.ConsoleList;

public class ConsolesResource extends Resource {

	
	public ConsoleList list() {
		return resource().get(ConsoleList.class);
	}
	
	public String create() {
		return resource().post(String.class);
	}
	
	public ConsoleResource console(String id) {
		return buildChildResource(id, ConsoleResource.class);
	}

}
