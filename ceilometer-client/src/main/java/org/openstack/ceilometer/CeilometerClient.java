package org.openstack.ceilometer;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;

public class CeilometerClient extends OpenStackClient {
	
	public CeilometerClient(String endpoint) {
		super(endpoint);
	}

	public CeilometerClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}
	
}
