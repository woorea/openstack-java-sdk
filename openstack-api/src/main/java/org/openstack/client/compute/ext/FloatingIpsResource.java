package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.FloatingIpList;

/**
 * Floating IPs support
 * 
 * @author sp
 *
 */
public class FloatingIpsResource extends Resource {

	/**
	 * Return a list of floating ips allocated to a project.
	 * 
	 * @return
	 */
	public FloatingIpList list() {
		return resource().get(FloatingIpList.class);
	}
	
	public FloatingIp create(String pool) {
		return resource().post(FloatingIp.class, pool);
	}
	
	public FloatingIp create() {
		return create(null);
	}
	
	public FloatingIpResource floatingIp(String id) {
		return buildChildResource(id, FloatingIpResource.class);
	}

}
