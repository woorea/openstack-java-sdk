package org.openstack.client.compute.notavailable;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

/**
 * Admin-only host administration
 * 
 * @author sp
 *
 */
public class HostResource extends Resource {

	public HostResource(Client client, String resource) {
		super(client, resource);
	}

}
