package org.openstack.client.identity;

import java.util.List;

import org.openstack.model.identity.RoleList;

import com.sun.jersey.api.client.Client;

public class RolesRepresentation {
		
	private Client client;
	
	private RoleList model;

	public RolesRepresentation(Client client, RoleList model) {
		this.client = client;
		this.model = model;
	}
	
	public List<org.openstack.model.identity.Role> getList() {
		return model.getList();
	}
	
	public RolesRepresentation next() {
		RoleList tenantList = client.resource(model.getLinks().get(0).getHref()).get(RoleList.class);
		return new RolesRepresentation(client, tenantList);
	}
	
}
