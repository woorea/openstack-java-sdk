package org.openstack.api.identity;

import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;

public class IdentityInternalEndpoint extends IdentityPublicEndpoint {

	public IdentityInternalEndpoint(Target target, Properties properties) {
		super(target, properties);
	}
	
	public static IdentityInternalEndpoint endpoint(Client client, String endpoint, Properties properties) {
		return new IdentityInternalEndpoint(client.target(endpoint), properties);
	}

}
