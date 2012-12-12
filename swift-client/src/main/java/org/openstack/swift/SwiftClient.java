package org.openstack.swift;

import javax.ws.rs.client.WebTarget;

import org.openstack.OpenStack;
import org.openstack.common.client.AbstractOpenStackClient;

public class SwiftClient extends AbstractOpenStackClient {
	
	public SwiftClient(String endpointURL, String token) {
		super(endpointURL, token);
	}

	public <R> R execute(SwiftCommand<R> command) {
		WebTarget endpoint = OpenStack.CLIENT.target(endpointURL);
		if(token != null) {
			endpoint.register(tokenFilter);
		}
		return command.execute(endpoint);
	}

}
