package org.openstack.heat.client;

import javax.ws.rs.client.WebTarget;

import org.openstack.OpenStack;
import org.openstack.common.client.AbstractOpenStackClient;

public class HeatClient extends AbstractOpenStackClient{

	public HeatClient(String endpointURL, String token) {
		super(endpointURL, token);
	}
	
	public <R> R execute(HeatCommand<R> command) {
		WebTarget endpoint = OpenStack.CLIENT.target(endpointURL);
		if(token != null) {
			endpoint.register(tokenFilter);
		}
		return command.execute(endpoint);
	}
}
