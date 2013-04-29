package org.openstack.keystone;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.keystone.api.EndpointsResource;
import org.openstack.keystone.api.RolesResource;
import org.openstack.keystone.api.ServicesResource;
import org.openstack.keystone.api.TenantsResource;
import org.openstack.keystone.api.TokensResource;
import org.openstack.keystone.api.UsersResource;

public class KeystoneClient extends OpenStackClient {
	
	private final TokensResource TOKENS;
	
	private final TenantsResource TENANTS;
	
	private final UsersResource USERS;
	
	private final RolesResource ROLES;
	
	private final ServicesResource SERVICES;
	
	private final EndpointsResource ENDPOINTS;
	
	public KeystoneClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		TOKENS = new TokensResource(this);
		TENANTS = new TenantsResource(this);
		USERS = new UsersResource(this);
		ROLES = new RolesResource(this);
		SERVICES = new ServicesResource(this);
		ENDPOINTS = new EndpointsResource(this);
	}
	
	public KeystoneClient(String endpoint) {
		this(endpoint, null);
	}
	
	public TokensResource tokens() {
		return TOKENS;
	}
	
	public TenantsResource tenants() {
		return TENANTS;
	}
	
	public UsersResource users() {
		return USERS;
	}
	
	public RolesResource roles() {
		return ROLES;
	}
	
	public ServicesResource services() {
		return SERVICES;
	}
	
	public EndpointsResource endpoints() {
		return ENDPOINTS;
	}

}
