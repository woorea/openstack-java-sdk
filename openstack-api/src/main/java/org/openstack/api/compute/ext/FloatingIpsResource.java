package org.openstack.api.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaCreateFloatingIpResponse;
import org.openstack.model.compute.NovaFloatingIp;
import org.openstack.model.compute.NovaFloatingIpList;

/**
 * Floating IPs support
 * 
 * @author sp
 * 
 */
public class FloatingIpsResource extends Resource {

	// Floating IPs seems to be JSON only
	// TODO: Is this an OpenStack bug or an HP bug?
	@Override
	protected MediaType getDefaultContentType() {
		return MediaType.APPLICATION_JSON_TYPE;
	}

	/**
	 * Return a list of floating ips allocated to a project.
	 * 
	 * @return
	 */
	public NovaFloatingIpList list() {
		return resource().get(NovaFloatingIpList.class);
	}

	public NovaFloatingIp create(String pool) {
		return resource().post(NovaFloatingIp.class, pool);
	}

	public NovaFloatingIp create() {
		NovaCreateFloatingIpResponse response = resource().post(NovaCreateFloatingIpResponse.class, "{}");
		return response.getFloatingIp();
	}

	public FloatingIpResource floatingIp(String id) {
		return buildChildResource(id, FloatingIpResource.class);
	}

}
