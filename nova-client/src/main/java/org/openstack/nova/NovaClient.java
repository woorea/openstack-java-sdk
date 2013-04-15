package org.openstack.nova;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;

public class NovaClient extends OpenStackClient {
	
	public NovaClient(String endpoint) {
		super(endpoint);
	}

	public NovaClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

}
