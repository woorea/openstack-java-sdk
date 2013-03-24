package org.openstack.swift;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public interface SwiftCommand<R> {

	R execute(OpenStackClientConnector connector, OpenStackRequest request);
	
}
