package org.openstack.ceilometer;

import javax.ws.rs.client.WebTarget;

public interface CeilometerCommand<R> {

	R execute(WebTarget endpoint);
	
}
