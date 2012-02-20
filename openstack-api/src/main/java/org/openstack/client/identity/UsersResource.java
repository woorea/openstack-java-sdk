package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.UserList;

public class UsersResource extends Resource {

	public UserList list() {
		return resource().get(UserList.class);
	}
	
//	public User create(Tenant tenant) {
//		return null;
//	}
	
	public UserResource user(String id) {
		return buildChildResource(id, UserResource.class);
	}
	
}
