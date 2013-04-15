package org.openstack.keystone;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public interface KeystoneCommand<R> extends OpenStackCommand<R> {

	OpenStackRequest execute(OpenStackClient client);
	
}
