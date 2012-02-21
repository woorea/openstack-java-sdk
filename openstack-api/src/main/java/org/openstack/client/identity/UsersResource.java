package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.client.common.SimplePagingList;
import org.openstack.model.identity.User;
import org.openstack.model.identity.UserList;

public class UsersResource extends Resource {

	public Iterable<User> list() {
		UserList list = resource().get(UserList.class);
		return new SimplePagingList<User>(session, list);
	}

	// public User create(Tenant tenant) {
	// return null;
	// }

	public UserResource user(String id) {
		return buildChildResource(id, UserResource.class);
	}

}
