package org.openstack.client.compute.notavailable;

import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;

public class FloatingIpDnsResource extends Resource {

	public FloatingIpDnsResource(Client client, String resource) {
		super(client, resource);
	}

}
