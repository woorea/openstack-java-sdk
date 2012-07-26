package org.openstack.keystone;

import javax.ws.rs.client.WebTarget;

public interface KeystoneCommand<R> {

	R execute(WebTarget endpoint);
	
}
