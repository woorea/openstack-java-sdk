package org.openstack.quantum.client;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class QuantumClient extends OpenStackClient {
	
	public QuantumClient(String endpoint) {
		super(endpoint);
	}
	
	public QuantumClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

	public <R> R execute(QuantumCommand<R> command) {
		OpenStackRequest request = command.execute(this);
		return (R) connector.execute(request, request.returnType());
	}
	
}
