package org.openstack.ceilometer;

import javax.ws.rs.client.WebTarget;

import org.openstack.OpenStack;
import org.openstack.common.client.AbstractOpenStackClient;

public class CeilometerClient extends AbstractOpenStackClient {
	
	public CeilometerClient(String endpointURL, String token) {
		super(endpointURL, token);
	}

	public <R> R execute(CeilometerCommand<R> command) {
		WebTarget endpoint = OpenStack.CLIENT.target(endpointURL);
		if(token != null) {
			endpoint.register(tokenFilter);
		}
		return command.execute(endpoint);
	}

	

}
