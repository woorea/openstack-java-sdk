package org.openstack.client.identity;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import org.openstack.model.identity.KeyStoneUser;
import org.openstack.model.identity.KeyStoneUserList;

public class UsersRepresentation {
		
	private Client client;
	
	private KeyStoneUserList model;

	public UsersRepresentation(Client client, KeyStoneUserList model) {
		this.client = client;
		this.model = model;
	}
	
	public List<KeyStoneUser> getList() {
		return model.getList();
	}
	
	public UsersRepresentation next() {
		KeyStoneUserList userList = client.target(model.getLinks().get(0).getHref()).request(MediaType.APPLICATION_XML).get(KeyStoneUserList.class);
		return new UsersRepresentation(client, userList);
	}
	
}
