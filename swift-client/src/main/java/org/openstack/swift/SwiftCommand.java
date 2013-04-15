package org.openstack.swift;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public interface SwiftCommand<R> extends OpenStackCommand<R> {

	OpenStackRequest execute(OpenStackClient client);
	
}
