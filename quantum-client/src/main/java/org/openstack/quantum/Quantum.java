package org.openstack.quantum;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;

public class Quantum extends OpenStackClient {
	
	public Quantum(String endpoint) {
		super(endpoint);
	}
	
	public Quantum(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

}
