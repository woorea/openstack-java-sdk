package org.openstack.client.compute;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.NovaConsoleList;

public class ConsolesResource extends Resource {

	
	public NovaConsoleList list() {
		return resource().get(NovaConsoleList.class);
	}
	
	public String create() {
		return resource().post(String.class);
	}
	
	public ConsoleResource console(String id) {
		return buildChildResource(id, ConsoleResource.class);
	}

}
