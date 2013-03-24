package org.openstack.ceilometer;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public interface CeilometerCommand<R> {

	R execute(OpenStackClientConnector connector, OpenStackRequest request);
	
}
