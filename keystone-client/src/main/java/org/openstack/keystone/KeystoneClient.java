package org.openstack.keystone;

import org.openstack.common.client.AbstractOpenStackClient;

public class KeystoneClient extends AbstractOpenStackClient {
	
	public KeystoneClient(String endpointURL, String token) {
		super(endpointURL, token);
	}
	
	public KeystoneClient(String endpointURL) {
		super(endpointURL, null);
	}

	public <R> R execute(KeystoneCommand<R> command) {
		return command.execute(create(endpointURL));
	}

}
