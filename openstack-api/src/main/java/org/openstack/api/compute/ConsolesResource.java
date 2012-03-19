package org.openstack.api.compute;

import org.openstack.api.common.Resource;
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
