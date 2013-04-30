package org.openstack.swift;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;

public class Swift extends OpenStackClient {
	
	public Swift(String endpoint) {
		super(endpoint);
	}
	
	public Swift(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

}
