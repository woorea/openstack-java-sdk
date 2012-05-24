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
public class NetworkResource extends Resource {

	public NetworkResource(Target target, Properties properties) {
		super(target, properties);
	}

	public String get() {
		return target.request(MediaType.APPLICATION_JSON).get(String.class);
	}
	
	public String delete() {
		return target.request(MediaType.WILDCARD).delete(String.class);
	}
	
}
