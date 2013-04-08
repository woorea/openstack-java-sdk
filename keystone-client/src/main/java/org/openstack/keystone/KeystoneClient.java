package org.openstack.keystone;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class KeystoneClient extends OpenStackClient {
	
	public KeystoneClient(String endpoint) {
		super(endpoint);
	}
	
	public KeystoneClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

	@SuppressWarnings("unchecked")
	public <R> R execute(KeystoneCommand<R> command) {
		OpenStackRequest request = command.execute(this);
		return (R) connector.execute(request, request.returnType());
	}
	
}
