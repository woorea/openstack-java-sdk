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

	public <R> R execute(SwiftCommand<R> command) {
		OpenStackRequest request = new OpenStackRequest();
		request.endpoint(endpoint);
		request.header("X-Auth-Token", properties.getProperty("os.token"));
		return command.execute(connector, request);
	}
	
}
