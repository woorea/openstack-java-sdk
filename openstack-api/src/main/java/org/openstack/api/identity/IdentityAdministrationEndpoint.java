package org.openstack.api.identity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.api.identity.resources.EndpointTemplatesResource;
import org.openstack.api.identity.resources.RolesResource;
import org.openstack.api.identity.resources.ServicesResource;
import org.openstack.api.identity.resources.TenantsResource;
import org.openstack.api.identity.resources.TokensResource;
import org.openstack.api.identity.resources.UsersResource;

public class IdentityAdministrationEndpoint extends Resource {

	public IdentityAdministrationEndpoint(Target target) {
		super(target);
	}
	
	public static IdentityAdministrationEndpoint endpoint(Client client, String endpoint) {
		return new IdentityAdministrationEndpoint(client.target(endpoint));
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
