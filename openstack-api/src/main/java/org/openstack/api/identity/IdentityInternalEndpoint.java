package org.openstack.api.identity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;

public class IdentityInternalEndpoint extends IdentityPublicEndpoint {

	public IdentityInternalEndpoint(Target target) {
		super(target);
	}
	
	public static IdentityInternalEndpoint endpoint(Client client, String endpoint) {
		return new IdentityInternalEndpoint(client.target(endpoint));
	}

}
