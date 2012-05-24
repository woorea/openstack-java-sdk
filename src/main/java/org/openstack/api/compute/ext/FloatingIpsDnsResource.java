package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;

public class FloatingIpsDnsResource extends Resource {

	public FloatingIpsDnsResource(Target target, Properties properties) {
		super(target, properties);
	}

	/**
	 * Return a list of dns entries for the specified domain and ip.
	 * 
	 * @return
	 */
	public String get(String ip) {
		return target.request(MediaType.APPLICATION_JSON).get(String.class);
	}
	
}
