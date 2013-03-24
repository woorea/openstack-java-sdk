package org.openstack.glance;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.base.client.OpenStackRequest;

public interface GlanceCommand<R> {

	R execute(OpenStackClientConnector connector, OpenStackRequest request);
	
}
