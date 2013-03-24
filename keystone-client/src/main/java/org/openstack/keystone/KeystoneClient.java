package org.openstack.keystone;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class KeystoneClient extends OpenStackClient {
	
	public KeystoneClient(String endpoint) {
		super(endpoint, null);
	}
	
	public KeystoneClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

	public <R> R execute(KeystoneCommand<R> command) {
		OpenStackRequest request = new OpenStackRequest();
		request.endpoint(endpoint);
		if(token != null) {
			request.header("X-Auth-Token", token);
		}
		return command.execute(connector, request);
	}
	
}
