package org.openstack.client.compute.notavailable;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

/**
 * Virtual Storage Arrays support
 * 
 * @author sp
 *
 */
public class VirtualStorageArraysResource extends Resource {

	public VirtualStorageArraysResource(Client client, String resource) {
		super(client, resource);
	}

}
