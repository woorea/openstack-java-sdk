package org.openstack.quantum;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackCommand;
import org.openstack.base.client.OpenStackRequest;

public interface QuantumCommand<R> extends OpenStackCommand<R> {
	
	OpenStackRequest execute(OpenStackClient client);

}
