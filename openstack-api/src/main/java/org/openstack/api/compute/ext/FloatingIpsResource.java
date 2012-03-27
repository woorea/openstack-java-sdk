package org.openstack.api.compute.ext;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.floatingip.NovaCreateFloatingIpResponse;
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

	protected FloatingIpsResource(Target target) {
		super(target);
	}
	
	public NovaFloatingIpList get() {
		return get(new HashMap<String, Object>());
	}

	/**
	 * Return a list of floating ips allocated to a project.
	 * 
	 * @return
	 */
	public NovaFloatingIpList get(Map<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(NovaFloatingIpList.class);
	}
	
	public NovaCreateFloatingIpResponse post() {
		throw new UnsupportedOperationException();
	}
	
	public NovaCreateFloatingIpResponse post(Map<String,Object> properties, String pool) {
		throw new UnsupportedOperationException();
		//return target.request(MediaType.APPLICATION_JSON).post(rule, NovaCreateFloatingIpResponse.class);
	}
	
	

	public FloatingIpResource floatingIp(String id) {
		return new FloatingIpResource(target.path("/{id}").pathParam("id", id));
	}

	

	

}
