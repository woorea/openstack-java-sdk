package org.openstack.nova;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;

public interface NovaCommand<R> {

	OpenStackRequest execute(OpenStackClient client);
	
}
