package org.openstack.client.identity;

import java.util.List;

import org.openstack.model.identity.KeyStoneRoleList;

import com.sun.jersey.api.client.Client;

public class RolesRepresentation {
		
	private Client client;
	
	private KeyStoneRoleList model;

	public RolesRepresentation(Client client, KeyStoneRoleList model) {
		this.client = client;
		this.model = model;
	}
	
	public List<org.openstack.model.identity.KeyStoneRole> getList() {
		return model.getList();
	}
	
	public RolesRepresentation next() {
		KeyStoneRoleList tenantList = client.resource(model.getLinks().get(0).getHref()).get(KeyStoneRoleList.class);
		return new RolesRepresentation(client, tenantList);
	}
	
}
