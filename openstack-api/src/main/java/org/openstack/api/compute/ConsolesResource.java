package org.openstack.api.compute;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaConsole;
import org.openstack.model.compute.NovaConsoleList;

public class ConsolesResource extends Resource {
	
	public ConsolesResource(Target target) {
		super(target);
	}

	public NovaConsoleList get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).get(NovaConsoleList.class);
	}
	
	public NovaConsole post(Map<String,Object> properties, Entity<NovaConsole> rule) {
		// OSAPI bug: Can't specify an SSH key in XML?
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).post(rule, NovaConsole.class);
	}
	
	public ConsoleResource console(String id) {
		return new ConsoleResource(target.path("/{id}").pathParam("id", id));
	}

}
