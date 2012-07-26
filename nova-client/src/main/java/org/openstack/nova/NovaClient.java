package org.openstack.nova;

import javax.ws.rs.client.WebTarget;

import org.openstack.OpenStack;
import org.openstack.common.client.AbstractOpenStackClient;

public class NovaClient extends AbstractOpenStackClient {
	
	public NovaClient(String endpointURL, String token) {
		super(endpointURL, token);
	}

	public <R> R execute(NovaCommand<R> command) {
		WebTarget endpoint = OpenStack.CLIENT.target(endpointURL);
		if(token != null) {
			endpoint.configuration().register(tokenFilter);
		}
		return command.execute(endpoint);
	}

}
