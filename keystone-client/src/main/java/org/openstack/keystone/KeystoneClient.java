package org.openstack.keystone;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.keystone.api.TenantsResource;

public class KeystoneClient extends OpenStackClient {
	
	public KeystoneClient(String endpoint) {
		super(endpoint);
	}
	
	public KeystoneClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}
	
	public TenantsResource tenants() {
		return new TenantsResource(this);
	}

}
