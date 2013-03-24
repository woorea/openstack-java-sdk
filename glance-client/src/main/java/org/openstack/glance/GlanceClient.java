package org.openstack.glance;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class GlanceClient extends OpenStackClient {
	
	public GlanceClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

	public <R> R execute(GlanceCommand<R> command) {
		OpenStackRequest request = new OpenStackRequest();
		request.endpoint(endpoint);
		request.header("X-Auth-Token", properties.getProperty("os.token"));
		return command.execute(connector, request);
	}
	
}
