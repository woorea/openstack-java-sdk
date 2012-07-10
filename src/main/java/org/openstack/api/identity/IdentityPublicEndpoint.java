package org.openstack.api.identity;

import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.api.identity.resources.TenantsResource;
import org.openstack.api.identity.resources.TokensResource;

public class IdentityPublicEndpoint extends Resource {

	public IdentityPublicEndpoint(Target target, Properties properties) {
		super(target, properties);
		if(Boolean.parseBoolean(properties.getProperty("verbose"))) {
			registerLoggingFilter(IdentityPublicEndpoint.class.getPackage().getName());
		}
	}

	public static IdentityPublicEndpoint endpoint(Client client, String endpoint, Properties properties) {
		return new IdentityPublicEndpoint(client.target(endpoint), properties);
	}

	public TokensResource tokens() {
		return path("/tokens", TokensResource.class);
	}

	public TenantsResource tenants() {
		return path("/tenants", TenantsResource.class);
	}

}
