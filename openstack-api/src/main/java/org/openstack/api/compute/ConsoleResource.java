package org.openstack.api.compute;

import java.util.Map;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaConsole;

public class ConsoleResource extends Resource {

	public ConsoleResource(Target target) {
		super(target);
	}

	public NovaConsole get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(NovaConsole.class);
	}
	
//	public void delete() {
//		 resource().post(String.class);
//	}
	
}

