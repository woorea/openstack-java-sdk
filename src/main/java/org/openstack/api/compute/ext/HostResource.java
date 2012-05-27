package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.host.NovaHost;
import org.openstack.model.compute.nova.host.UpdateNovaHostRequest;

/**
 * Admin-only host administration
 * 
 * @author sp
 *
 */
public class HostResource extends Resource {

	public HostResource(Target target, Properties properties) {
		super(target, properties);
	}

	public String put(UpdateNovaHostRequest request) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(request), String.class);
	}
	
	public NovaHost get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaHost.class);
	}
	
	public String get(HostAction action) {
		switch (action) {
		case STARTUP:
			return target.path("/startup").request(MediaType.APPLICATION_JSON).get(String.class);
		case SHUTDOWN:
			return target.path("/shutdown").request(MediaType.APPLICATION_JSON).get(String.class);
		case REBOOT:
			return target.path("/reboot").request(MediaType.APPLICATION_JSON).get(String.class);
		default:
			throw new UnsupportedOperationException();
		}
		
	}
	
	public static enum HostAction {
		STARTUP, SHUTDOWN, REBOOT
	}

}
