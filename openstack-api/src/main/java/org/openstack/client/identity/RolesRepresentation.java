package org.openstack.client.identity;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import org.openstack.model.identity.KeyStoneRoleList;

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
		KeyStoneRoleList tenantList = client.target(model.getLinks().get(0).getHref()).request(MediaType.APPLICATION_XML).get(KeyStoneRoleList.class);
		return new RolesRepresentation(client, tenantList);
	}
	
}
