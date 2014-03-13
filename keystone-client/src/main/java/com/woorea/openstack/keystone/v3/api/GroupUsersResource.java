package com.woorea.openstack.keystone.v3.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.keystone.v3.model.User;
import com.woorea.openstack.keystone.v3.model.Users;


public class GroupUsersResource extends GenericResource<User, Users> {

	public GroupUsersResource(OpenStackClient client, String path) {
		super(client, path, User.class, Users.class);
	}

}
