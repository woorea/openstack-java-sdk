package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;

/**
 * Admin-only Network Management Extension
 * 
 * @author sp
 *
 */
public class NetworksResource extends Resource {

	public NetworksResource(Target target, Properties properties) {
		super(target, properties);
	}

	public String get() {
		return target.request(MediaType.APPLICATION_JSON).get(String.class);
	}
	
	public NetworkResource network(String id) {
		return new NetworkResource(target.path("/{networkId}").pathParam("networkId", id), properties);
	}
}
