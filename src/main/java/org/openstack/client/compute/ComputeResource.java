package org.openstack.client.compute;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

public class ComputeResource extends Resource {

	public ComputeResource(Client client, String resource) {
		super(client, resource);
	}
	
	public TenantResource tenant(String id) {
		return new TenantResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}

}
