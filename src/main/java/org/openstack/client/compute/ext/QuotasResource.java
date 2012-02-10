package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

/**
 * Quotas management support
 * 
 * @author sp
 *
 */
public class QuotasResource extends Resource {

	public QuotasResource(Client client, String resource) {
		super(client, resource);
	}
	
	public String show() {
		return null;
	}
	
	public String update() {
		return null;
	}

}
