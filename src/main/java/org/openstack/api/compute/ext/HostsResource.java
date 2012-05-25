package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;

/**
 * Admin-only host administration
 * 
 * @author sp
 *
 */
public class HostsResource extends Resource {

	public HostsResource(Target target, Properties properties) {
		super(target, properties);
	}

	/**
	 * Shows the physical/usage resource given by hosts.
	 * @return
	 */
	public String get() {
		return target.request(MediaType.APPLICATION_JSON).get(String.class);
	}
	
	public HostResource host(String id) {
		return new HostResource(target.path("/{hostId}").pathParam("hostId", id), properties);
	}
	
}
