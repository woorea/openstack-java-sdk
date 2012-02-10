package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

/**
 * Instance rescue mode
 * 
 * @author sp
 *
 */
public class RescueResource extends Resource {

	public RescueResource(Client client, String resource) {
		super(client, resource);
	}
	
	

}
