package org.openstack.quantum.client;

import javax.ws.rs.client.WebTarget;

public interface QuantumCommand<R> {
	
	R execute(WebTarget target);

}
