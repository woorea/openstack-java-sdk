package org.openstack.glance;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class GlanceClient extends OpenStackClient {
	
	public GlanceClient(String endpoint) {
		super(endpoint);
	}

	public GlanceClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

	@SuppressWarnings("unchecked")
	public <R> R execute(GlanceCommand<R> command) {
		OpenStackRequest request = command.execute(this);
		return (R) connector.execute(request, request.returnType());
	}
	
}
