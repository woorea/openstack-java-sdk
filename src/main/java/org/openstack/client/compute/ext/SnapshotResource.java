package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

public class SnapshotResource extends Resource {

	public SnapshotResource(Client client, String resource) {
		super(client, resource);
	}

}
