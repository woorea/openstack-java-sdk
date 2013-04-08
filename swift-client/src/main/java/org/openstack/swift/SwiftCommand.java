package org.openstack.swift;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;

public interface SwiftCommand<R> {

	OpenStackRequest execute(OpenStackClient client);
	
}
