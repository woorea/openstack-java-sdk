package org.openstack.api.compute;

import org.openstack.api.common.OpenStackSession;
import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaConsole;

public class ConsoleResource extends Resource {
	
	public ConsoleResource(OpenStackSession session, String resource) {
		super(session, resource);
	}

	public NovaConsole show() {
		return resource().get(NovaConsole.class);
	}
	
//	public void delete() {
//		 resource().post(String.class);
//	}
	
}

