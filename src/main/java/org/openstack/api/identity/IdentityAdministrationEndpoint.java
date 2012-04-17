package org.openstack.api.identity;

import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.api.identity.admin.resources.EndpointsResource;
import org.openstack.api.identity.admin.resources.RolesResource;
import org.openstack.api.identity.admin.resources.ServicesResource;
import org.openstack.api.identity.admin.resources.TenantsResource;
import org.openstack.api.identity.admin.resources.TokensResource;
import org.openstack.api.identity.admin.resources.UsersResource;

public class IdentityAdministrationEndpoint extends Resource {

	public IdentityAdministrationEndpoint(Target target, Properties properties) {
		super(target, properties);
	}
	
	public static IdentityAdministrationEndpoint endpoint(Client client, String endpoint, Properties properties) {
		return new IdentityAdministrationEndpoint(client.target(endpoint), properties);
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

	public EndpointsResource endpoints() {
		return path("/endpoints", EndpointsResource.class);
	}

}
