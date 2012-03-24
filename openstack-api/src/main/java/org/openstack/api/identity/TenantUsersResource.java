package org.openstack.api.identity;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneUserList;

public class TenantUsersResource extends Resource {

	public TenantUsersResource(Target target) {
		super(target);
	}
	
	public KeystoneUserList get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneUserList.class);
		
	}

	public TenantUserResource user(String id) {
		return new TenantUserResource(target.path("/{id}").pathParam("id", id));
	}

}
