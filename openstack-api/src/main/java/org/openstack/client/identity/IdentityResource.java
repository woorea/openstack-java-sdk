package org.openstack.client.identity;
import org.openstack.client.common.Resource;

import com.sun.jersey.api.client.Client;


public class IdentityResource extends Resource {

	private TokensResource tokens;
	
	private TenantsResource tenants;
	
	private UsersResource users;
	
	private RolesResource roles;
	
	private ServicesResource services;
	
	private EndpointTemplatesResource endpointTemplates;
	
	public IdentityResource(Client client, String resource) {
		super(client, resource);
	}
	
	public TokensResource tokens() {
		if(tokens == null) {
			tokens = new TokensResource(client, new StringBuilder(resource).append("/tokens").toString());
		}
		return tokens;
	}
	
	public TenantsResource tenants() {
		if(tenants == null) {
			tenants = new TenantsResource(client, new StringBuilder(resource).append("/tenants").toString());
		}
		return tenants;
	}
	
	public UsersResource users() {
		if(users == null) {
			users = new UsersResource(client, new StringBuilder(resource).append("/users").toString());
		}
		return users;
	}
	
	public RolesResource roles() {
		if(roles == null) {
			roles = new RolesResource(client, new StringBuilder(resource).append("/OS-KSADM/roles").toString());
		}
		return roles;
	}
	
	public ServicesResource services() {
		if(services == null) {
			services = new ServicesResource(client, new StringBuilder(resource).append("/OS-KSADM/services").toString());
		}
		return services;
	}
	
	public EndpointTemplatesResource endpointTemplates() {
		if(endpointTemplates == null) {
			endpointTemplates = new EndpointTemplatesResource(client, new StringBuilder(resource).append("/OS-KSCATALOG/endpointTemplates").toString());
		}
		return endpointTemplates;
	}
	
}
