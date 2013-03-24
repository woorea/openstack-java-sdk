package org.openstack.keystone;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public interface KeystoneCommand<R> {

	R execute(OpenStackClientConnector connector, OpenStackRequest request);
	
}
