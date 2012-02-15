package org.openstack.client.identity;
import org.openstack.client.common.Resource;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.User;
import org.openstack.model.identity.UserList;

import com.sun.jersey.api.client.Client;

public class UsersResource extends Resource {
	
	public UsersResource(Client client, String resource) {
		super(client, resource);
	}

	public UsersRepresentation list() {
		UserList userList = client.resource(resource).get(UserList.class);
		return new UsersRepresentation(client, userList);
	}
	
	public User create(Tenant tenant) {
		return null;
	}
	
	public UserResource user(String id) {
		return new UserResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}
	
}
