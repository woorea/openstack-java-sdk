package org.openstack.glance;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;

public class GlanceClient extends OpenStackClient {
	
	public GlanceClient(String endpoint) {
		super(endpoint);
	}

	public GlanceClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}

}
