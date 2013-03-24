package org.openstack.quantum.client;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public interface QuantumCommand<R> {
	
	R execute(OpenStackClientConnector connector, OpenStackRequest request);

}
