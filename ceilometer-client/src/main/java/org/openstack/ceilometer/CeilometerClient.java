package org.openstack.ceilometer;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class CeilometerClient extends OpenStackClient {
	
	public CeilometerClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}
	
	public CeilometerClient(String endpoint) {
		super(endpoint, null);
	}

	public <R> R execute(CeilometerCommand<R> command) {
		OpenStackRequest request = new OpenStackRequest();
		request.endpoint(endpoint);
		request.header("X-Auth-Token", properties.getProperty("os.token"));
		return command.execute(connector, request);
	}
	
}
