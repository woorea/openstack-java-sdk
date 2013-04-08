package org.openstack.nova;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class NovaClient extends OpenStackClient {
	
	public NovaClient(String endpoint) {
		super(endpoint);
	}

	public NovaClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

	@SuppressWarnings("unchecked")
	public <R> R execute(NovaCommand<R> command) {
		OpenStackRequest request = command.execute(this);
		return (R) connector.execute(request, request.returnType());
	}
	
}
