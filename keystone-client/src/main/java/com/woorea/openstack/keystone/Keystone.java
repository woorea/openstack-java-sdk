package com.woorea.openstack.keystone;

import com.woorea.openstack.keystone.api.EndpointsResource;
import com.woorea.openstack.keystone.api.RolesResource;
import com.woorea.openstack.keystone.api.ServicesResource;
import com.woorea.openstack.keystone.api.TenantsResource;
import com.woorea.openstack.keystone.api.TokensResource;
import com.woorea.openstack.keystone.api.UsersResource;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;

public class Keystone extends OpenStackClient {
	
	private final TokensResource TOKENS;
	
	private final TenantsResource TENANTS;
	
	private final UsersResource USERS;
	
	private final RolesResource ROLES;
	
	private final ServicesResource SERVICES;
	
	private final EndpointsResource ENDPOINTS;
	
	public Keystone(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		TOKENS = new TokensResource(this);
		TENANTS = new TenantsResource(this);
		USERS = new UsersResource(this);
		ROLES = new RolesResource(this);
		SERVICES = new ServicesResource(this);
		ENDPOINTS = new EndpointsResource(this);
	}
	
	public Keystone(String endpoint) {
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
