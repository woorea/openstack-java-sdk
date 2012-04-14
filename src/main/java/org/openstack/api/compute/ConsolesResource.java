package org.openstack.api.compute;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Console;
import org.openstack.model.compute.ConsoleList;
import org.openstack.model.compute.nova.NovaConsole;
import org.openstack.model.compute.nova.NovaConsoleList;

public class ConsolesResource extends Resource {
	
	public ConsolesResource(Target target) {
		super(target);
	}

	public ConsoleList get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaConsoleList.class);
	}
	
	public Console post(Entity<NovaConsole> rule) {
		// OSAPI bug: Can't specify an SSH key in XML?
		return target.request(MediaType.APPLICATION_JSON).post(rule, NovaConsole.class);
	}
	
	public ConsoleResource console(String id) {
		return new ConsoleResource(target.path("/{id}").pathParam("id", id));
	}

}
