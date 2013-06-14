package org.openstack.heat.client;

import javax.ws.rs.client.WebTarget;

public interface HeatCommand<R>{
	
	R execute(WebTarget endpoint);
}
