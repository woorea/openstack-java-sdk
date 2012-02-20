package org.openstack.client.compute;

import org.openstack.client.common.OpenstackSession;
import org.openstack.client.common.Resource;
import org.openstack.model.compute.Console;

import com.sun.jersey.api.client.Client;

public class ConsoleResource extends Resource {
	
	public ConsoleResource(OpenstackSession session, String resource) {
		super(session, resource);
	}

	public Console show() {
		return resource().get(Console.class);
	}
	
//	public void delete() {
//		 resource().post(String.class);
//	}
	
}

