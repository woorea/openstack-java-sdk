package org.openstack.ceilometer;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;

public interface CeilometerCommand<R> {

	OpenStackRequest execute(OpenStackClient client);
	
}
