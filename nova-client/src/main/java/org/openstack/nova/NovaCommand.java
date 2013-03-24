package org.openstack.nova;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public interface NovaCommand<R> {

	R execute(OpenStackClientConnector connector, OpenStackRequest request);
	
}
