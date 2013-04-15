package org.openstack.nova;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public interface NovaCommand<R> extends OpenStackCommand<R> {

	OpenStackRequest execute(OpenStackClient client);
	
}
