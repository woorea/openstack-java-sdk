package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.client.common.SimplePagingList;
import org.openstack.model.identity.KeyStoneUser;
import org.openstack.model.identity.KeyStoneUserList;

public class UsersResource extends Resource {

	public KeyStoneUserList list() {
		return resource().get(KeyStoneUserList.class);
	}

	// public User create(Tenant tenant) {
	// return null;
	// }

	public UserResource user(String id) {
		return buildChildResource(id, UserResource.class);
	}

}
