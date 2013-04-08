package org.openstack.glance;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;

public interface GlanceCommand<R> {

	OpenStackRequest execute(OpenStackClient client);
	
}
