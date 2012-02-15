package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

/**
 * Simple tenant usage extension
 * 
 * @author sp
 *
 */
public class SimpleTenantUsageResource extends Resource {

	public SimpleTenantUsageResource(Client client, String resource) {
		super(client, resource);
	}

}
