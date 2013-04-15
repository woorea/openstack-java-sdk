package org.openstack.quantum;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;

public interface QuantumCommand<R> {
	
	OpenStackRequest execute(OpenStackClient client);

}
