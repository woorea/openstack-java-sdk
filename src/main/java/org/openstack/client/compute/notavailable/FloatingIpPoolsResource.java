package org.openstack.client.compute.notavailable;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

/**
 * Floating IPs support
 * 
 * @author sp
 *
 */
public class FloatingIpPoolsResource extends Resource {

	public FloatingIpPoolsResource(Client client, String resource) {
		super(client, resource);
	}

}
