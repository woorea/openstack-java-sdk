package org.openstack.client.identity;

import org.openstack.client.common.Resource;
import org.openstack.client.common.SimplePagingList;
import org.openstack.model.identity.KeyStoneUser;
import org.openstack.model.identity.KeyStoneUserList;

public class UsersResource extends Resource {

	public Iterable<KeyStoneUser> list() {
		KeyStoneUserList list = resource().get(KeyStoneUserList.class);
		return new SimplePagingList<KeyStoneUser>(session, list);
	}

	// public User create(Tenant tenant) {
	// return null;
	// }

	public UserResource user(String id) {
		return buildChildResource(id, UserResource.class);
	}

}
