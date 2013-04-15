package org.openstack.swift;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;

public class SwiftClient extends OpenStackClient {
	
	public SwiftClient(String endpoint) {
		super(endpoint);
	}
	
	public SwiftClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

}
