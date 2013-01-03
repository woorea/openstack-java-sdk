package org.openstack.glance;

import javax.ws.rs.client.WebTarget;

import org.openstack.OpenStack;
import org.openstack.common.client.AbstractOpenStackClient;

public class GlanceClient extends AbstractOpenStackClient {
	
	public GlanceClient(String endpointURL, String token) {
		super(endpointURL, token);
	}

	public <R> R execute(GlanceCommand<R> command) {
		WebTarget endpoint = OpenStack.CLIENT.target(endpointURL);
		if(token != null) {
			endpoint.configuration().register(tokenFilter);
		}
		return command.execute(endpoint);
	}

}
