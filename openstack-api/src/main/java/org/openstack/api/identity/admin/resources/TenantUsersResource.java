package org.openstack.api.identity.admin.resources;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.UserList;
import org.openstack.model.identity.keystone.KeystoneUserList;

public class TenantUsersResource extends Resource {

	public TenantUsersResource(Target target) {
		super(target);
	}
	
	public UserList get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneUserList.class);
		
	}

	public TenantUserResource user(String id) {
		return new TenantUserResource(target.path("/{userId}").pathParam("userId", id));
	}

}
