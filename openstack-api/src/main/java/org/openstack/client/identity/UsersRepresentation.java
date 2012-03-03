package org.openstack.client.identity;

import java.util.List;

import org.openstack.model.identity.UserList;
import org.openstack.model.identity.keystone.KeyStoneUser;

import com.sun.jersey.api.client.Client;

public class UsersRepresentation {
		
	private Client client;
	
	private UserList model;

	public UsersRepresentation(Client client, UserList model) {
		this.client = client;
		this.model = model;
	}
	
	public List<KeyStoneUser> getList() {
		return model.getList();
	}
	
	public UsersRepresentation next() {
		UserList userList = client.resource(model.getLinks().get(0).getHref()).get(UserList.class);
		return new UsersRepresentation(client, userList);
	}
	
}
