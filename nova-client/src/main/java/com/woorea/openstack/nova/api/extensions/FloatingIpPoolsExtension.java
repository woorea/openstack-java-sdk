package com.woorea.openstack.nova.api.extensions;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.FloatingIpPools;

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
