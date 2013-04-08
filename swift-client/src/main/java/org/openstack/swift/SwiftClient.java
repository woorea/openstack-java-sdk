package org.openstack.swift;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class SwiftClient extends OpenStackClient {
	
	public SwiftClient(String endpoint) {
		super(endpoint);
	}
	
	public SwiftClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

	@SuppressWarnings("unchecked")
	public <R> R execute(SwiftCommand<R> command) {
		OpenStackRequest request = command.execute(this);
		return (R) connector.execute(request, request.returnType());
	}
	
}
