package org.openstack.api.identity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.api.identity.resources.TenantsResource;
import org.openstack.api.identity.resources.TokensResource;

public class IdentityPublicEndpoint extends Resource {

	public IdentityPublicEndpoint(Target target) {
		super(target);
	}
	
	public static IdentityPublicEndpoint endpoint(Client client, String endpoint) {
		return new IdentityPublicEndpoint(client.target(endpoint));
	}

	public TokensResource tokens() {
		return path("/tokens", TokensResource.class);
	}

	public TenantsResource tenants() {
		return path("/tenants", TenantsResource.class);
	}

}
