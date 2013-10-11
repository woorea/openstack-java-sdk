package org.openstack.swift;

import javax.ws.rs.client.WebTarget;

import org.openstack.OpenStack;
import org.openstack.common.client.AbstractOpenStackClient;

public class SwiftClient extends AbstractOpenStackClient {
	
	public SwiftClient(String endpointURL, String token) {
		super(endpointURL, token);
	}

	public <R> R execute(SwiftCommand<R> command) {
		final WebTarget endpoint = OpenStack.CLIENT.target(endpointURL);
		if(token != null) {
			return command.execute(endpoint, token);
		} else {
			return command.execute(endpoint);
		}
	}

}
