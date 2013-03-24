package org.openstack.base.client;

public interface OpenStackCommand<R> {

	R execute(OpenStackClientConnector connector, OpenStackRequest request);

}
