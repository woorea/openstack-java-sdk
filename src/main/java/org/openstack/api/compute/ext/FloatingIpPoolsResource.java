package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.FloatingIpList;
import org.openstack.model.compute.nova.floatingip.NovaFloatingIpList;

/**
 * Floating IPs support
 * 
 * @author sp
 *
 */
public class FloatingIpPoolsResource extends Resource {
	
	public FloatingIpPoolsResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	/**
	 * Return a list of floating ips allocated to a project.
	 * 
	 * @return
	 */
	public String get() {
		return target.request(MediaType.APPLICATION_JSON).get(String.class);
	}


}
