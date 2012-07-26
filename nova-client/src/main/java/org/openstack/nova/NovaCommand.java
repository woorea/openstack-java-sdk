package org.openstack.nova;

import javax.ws.rs.client.WebTarget;

public interface NovaCommand<R> {

	R execute(WebTarget endpoint);
	
}
