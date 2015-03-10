package com.woorea.openstack.nova.api.extensions;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.TenantNetworks;

public class TenantNetworksExtension {
	
	private final OpenStackClient CLIENT;
	
	public TenantNetworksExtension(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list() {
		return new List();
	}

	public class List extends OpenStackRequest<TenantNetworks> {

		public List() {
			super(CLIENT, HttpMethod.GET, "/os-tenant-networks", null, TenantNetworks.class);
		}

	}

}
