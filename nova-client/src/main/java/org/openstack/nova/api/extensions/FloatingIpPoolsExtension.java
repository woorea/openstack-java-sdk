package org.openstack.nova.api.extensions;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.FloatingIpPools;

public class FloatingIpPoolsExtension {
	
	private final OpenStackClient CLIENT;
	
	public FloatingIpPoolsExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}

	public class List extends OpenStackRequest<FloatingIpPools> {

		public List() {
			super(CLIENT, HttpMethod.GET, "/os-floating-ip-pools", null, FloatingIpPools.class);
		}

	}

	

}
