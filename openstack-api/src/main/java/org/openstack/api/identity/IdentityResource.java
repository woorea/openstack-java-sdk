package org.openstack.api.identity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;

import org.openstack.api.common.OpenStackSession;
import org.openstack.api.common.Resource;
import org.openstack.api.common.RestClient;

public class IdentityResource extends Resource {

	public IdentityResource() {
	}

	public IdentityResource(OpenStackSession session, String resource) {
		initialize(session, resource);
	}
	
	private IdentityResource(Target target) {
		super(target);
	}
	
	public static IdentityResource endpoint(String endpoint) {
		Client client = RestClient.INSTANCE.verbose(true).getJerseyClient();
		return new IdentityResource(client.target(endpoint));
	}

	public TokensResource tokens() {
		return target("/tokens", TokensResource.class);
	}

	public TenantsResource tenants() {
		return target("/tenants", TenantsResource.class);
	}

	public UsersResource users() {
		return target("/users", UsersResource.class);
	}

	public RolesResource roles() {
		return target("/OS-KSADM/roles", RolesResource.class);
	}

	public ServicesResource services() {
		return target("/OS-KSADM/services", ServicesResource.class);
	}

	public EndpointTemplatesResource endpoints() {
		//throw new UnsupportedOperationException("This is not implemented yet in the api (19 mar 2012)");
		return target("/endpoints", EndpointTemplatesResource.class);
	}

}
