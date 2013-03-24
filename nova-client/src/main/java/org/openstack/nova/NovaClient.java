package org.openstack.nova;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class NovaClient extends OpenStackClient {
	
	public NovaClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}
	
	public NovaClient(String endpoint, String token) {
		super(endpoint, null);
	}

	public <R> R execute(NovaCommand<R> command) {
		OpenStackRequest request = newOpenStackRequest();
		return command.execute(connector, request);
	}
	
}
