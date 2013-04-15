package org.openstack.quantum;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;

public class QuantumClient extends OpenStackClient {
	
	public QuantumClient(String endpoint) {
		super(endpoint);
	}
	
	public QuantumClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

}
