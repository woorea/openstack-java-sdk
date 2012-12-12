package org.openstack.keystone;

import javax.ws.rs.client.WebTarget;

import org.openstack.OpenStack;
import org.openstack.common.client.AbstractOpenStackClient;

public class KeystoneClient extends AbstractOpenStackClient {
	
	public KeystoneClient(String endpointURL, String token) {
		super(endpointURL, token);
	}
	
	public KeystoneClient(String endpointURL) {
		super(endpointURL, null);
	}

	public <R> R execute(KeystoneCommand<R> command) {
		WebTarget endpoint = OpenStack.CLIENT.target(endpointURL);
		if(token != null) {
			endpoint.register(tokenFilter);
		}
		return command.execute(endpoint);
	}

}
