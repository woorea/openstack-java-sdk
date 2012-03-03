package org.openstack.client.identity;

import javax.ws.rs.core.MediaType;

import org.openstack.client.common.Resource;
import org.openstack.model.identity.User;
import org.openstack.model.identity.keystone.KeyStoneUser;

public class UserResource extends Resource {

	public User show() {
		return resource().get(KeyStoneUser.class);
	}

//	public User update() {
//		return resource().put(User.class);
//	}

	public void delete() {
		 resource().delete();
	}

}
