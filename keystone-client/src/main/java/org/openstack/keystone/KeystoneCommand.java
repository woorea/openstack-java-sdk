package org.openstack.keystone;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;

public interface KeystoneCommand<R> {

	OpenStackRequest execute(OpenStackClient client);
	
}
