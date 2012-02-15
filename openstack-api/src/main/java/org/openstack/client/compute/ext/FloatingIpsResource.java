package org.openstack.client.compute.ext;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.FloatingIpList;
import org.openstack.model.compute.ImageList;

import com.sun.jersey.api.client.Client;

/**
 * Floating IPs support
 * 
 * @author sp
 *
 */
public class FloatingIpsResource extends Resource {

	public FloatingIpsResource(Client client, String resource) {
		super(client, resource);
	}
	
	/**
	 * Return a list of floating ips allocated to a project.
	 * 
	 * @return
	 */
	public FloatingIpList list() {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).get(FloatingIpList.class);
	}
	
	public FloatingIp create(String pool) {
		return client.resource(resource).accept(MediaType.APPLICATION_XML).post(FloatingIp.class, pool);
	}
	
	public FloatingIp create() {
		return create(null);
	}
	
	public FloatingIpResource floatingIp(String id) {
		return new FloatingIpResource(client, new StringBuilder().append("/").append(id).toString());
	}

}
