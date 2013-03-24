package org.openstack.quantum.client;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class QuantumClient extends OpenStackClient {
	
	public QuantumClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}
	
	public QuantumClient(String endpoint) {
		this(endpoint, null);
	}

	public <R> R execute(QuantumCommand<R> command) {
		OpenStackRequest request = new OpenStackRequest();
		request.endpoint(endpoint);
		request.header("X-Auth-Token", properties.getProperty("os.token"));
		return command.execute(connector, request);
	}
	
}
