package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

public class SnapshotsResource extends Resource {

	public SnapshotsResource(Client client, String resource) {
		super(client, resource);
	}

}
