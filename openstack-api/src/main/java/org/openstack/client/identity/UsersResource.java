package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.client.common.SimplePagingList;
import org.openstack.model.identity.UserList;
import org.openstack.model.identity.keystone.KeyStoneUser;

public class UsersResource extends Resource {

	public Iterable<KeyStoneUser> list() {
		UserList list = resource().get(UserList.class);
		return new SimplePagingList<KeyStoneUser>(session, list);
	}

	// public User create(Tenant tenant) {
	// return null;
	// }

	public UserResource user(String id) {
		return buildChildResource(id, UserResource.class);
	}

}
