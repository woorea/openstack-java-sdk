package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.FloatingIpList;
import org.openstack.model.compute.nova.floatingip.NovaFloatingIp;
import org.openstack.model.compute.nova.floatingip.NovaFloatingIpList;

/**
 * Floating IPs support
 * 
 * @author sp
 * 
 */
//Floating IPs seems to be JSON only
// TODO: Is this an OpenStack bug or an HP bug?
public class FloatingIpsResource extends Resource {

	public FloatingIpsResource(Target target, Properties properties) {
		super(target, properties);
	}

	/**
	 * Return a list of floating ips allocated to a project.
	 * 
	 * @return
	 */
	public FloatingIpList get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaFloatingIpList.class);
	}
	
	public FloatingIp post(String pool) {
		return target.request(MediaType.APPLICATION_JSON).post(null,NovaFloatingIp.class);
	}
	
	public FloatingIpResource floatingIp(Integer id) {
		return new FloatingIpResource(target.path("/{id}").pathParam("id", id), properties);
	}

}
