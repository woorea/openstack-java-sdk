package org.openstack.client.identity;

import java.util.List;

import org.openstack.model.identity.KeyStoneUser;
import org.openstack.model.identity.KeyStoneUserList;

import com.sun.jersey.api.client.Client;

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
		KeyStoneUserList userList = client.resource(model.getLinks().get(0).getHref()).get(KeyStoneUserList.class);
		return new UsersRepresentation(client, userList);
	}
	
}
