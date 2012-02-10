package org.openstack.client.compute.notavailable;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

/**
 * Admin-only Network Management Extension
 * 
 * @author sp
 *
 */
public class NetworksResource extends Resource {

	public NetworksResource(Client client, String resource) {
		super(client, resource);
	}

}
