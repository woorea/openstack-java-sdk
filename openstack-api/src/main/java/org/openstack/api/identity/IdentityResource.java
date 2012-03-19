package org.openstack.api.identity;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.RequestFilter;

import org.openstack.api.OpenStackSession2;
import org.openstack.api.common.Resource;
import org.openstack.api.common.RestClient;
import org.openstack.client.OpenStackSession;

public class IdentityResource extends Resource {

	public IdentityResource() {
	}

	public IdentityResource(OpenStackSession session, String resource) {
		initialize(session, resource);
	}
	
	private IdentityResource(Target target) {
		super(target);
	}
	
	public static IdentityResource endpoint(Client client, String endpoint) {
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

	public void setSession(final OpenStackSession2 session) {
		target.configuration().register(new RequestFilter() {
			
			@Override
			public void preFilter(FilterContext context) throws IOException {
				context.getRequestBuilder().header("X-Auth-Token", session.getAccess().getToken().getId());
				
			}
		});
	}

}
