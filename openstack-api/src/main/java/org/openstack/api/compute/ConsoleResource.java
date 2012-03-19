package org.openstack.api.compute;

import java.util.Map;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.client.OpenStackSession;
import org.openstack.model.compute.NovaConsole;

public class ConsoleResource extends Resource {
	
	public ConsoleResource(OpenStackSession session, String resource) {
		super(session, resource);
	}

	public ConsoleResource(Target target) {
		super(target);
	}

	public NovaConsole get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).get(NovaConsole.class);
	}
	
//	public void delete() {
//		 resource().post(String.class);
//	}
	
}

