package org.openstack.api.identity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;

public class IdentityResource extends Resource {

	public IdentityResource(Target target) {
		super(target);
	}
	
	public static IdentityResource endpoint(Client client, String endpoint) {
		return new IdentityResource(client.target(endpoint));
	}

	public TokensResource tokens() {
		return path("/tokens", TokensResource.class);
	}

	public TenantsResource tenants() {
		return path("/tenants", TenantsResource.class);
	}

	public UsersResource users() {
		return path("/users", UsersResource.class);
	}

	public RolesResource roles() {
		return path("/OS-KSADM/roles", RolesResource.class);
	}

	public ServicesResource services() {
		return path("/OS-KSADM/services", ServicesResource.class);
	}

	public EndpointTemplatesResource endpoints() {
		//throw new UnsupportedOperationException("This is not implemented yet in the api (19 mar 2012)");
		return path("/endpoints", EndpointTemplatesResource.class);
	}

}
