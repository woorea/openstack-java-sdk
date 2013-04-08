package org.openstack.ceilometer;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public class CeilometerClient extends OpenStackClient {
	
	public CeilometerClient(String endpoint) {
		super(endpoint);
	}

	public CeilometerClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
	}
	
	public <R> R execute(CeilometerCommand<R> command) {
		OpenStackRequest request = command.execute(this);
		return (R) connector.execute(request, request.returnType());
	}
	
}
