package org.openstack.glance;

import javax.ws.rs.client.WebTarget;

public interface GlanceCommand<R> {

	R execute(WebTarget endpoint);
	
}
