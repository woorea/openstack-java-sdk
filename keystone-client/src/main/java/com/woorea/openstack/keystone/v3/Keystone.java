package com.woorea.openstack.keystone.v3;

import com.woorea.openstack.keystone.v3.api.DomainsResource;
import com.woorea.openstack.keystone.v3.api.EndpointsResource;
import com.woorea.openstack.keystone.v3.api.RolesResource;
import com.woorea.openstack.keystone.v3.api.ServicesResource;
import com.woorea.openstack.keystone.v3.api.ProjectsResource;
import com.woorea.openstack.keystone.v3.api.TokensResource;
import com.woorea.openstack.keystone.v3.api.UsersResource;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;

public class Keystone extends OpenStackClient {
	
	private final TokensResource TOKENS;
	
	private final DomainsResource DOMAINS;
	
	private final ProjectsResource PROJECTS;
	
	private final UsersResource USERS;
	
	private final RolesResource ROLES;
	
	private final ServicesResource SERVICES;
	
	private final EndpointsResource ENDPOINTS;
	
	public Keystone(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		TOKENS = new TokensResource(this);
		DOMAINS = new DomainsResource(this);
		PROJECTS = new ProjectsResource(this);
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
	
	public DomainsResource domains() {
		return DOMAINS;
	}
	
	public ProjectsResource projects() {
		return PROJECTS;
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

